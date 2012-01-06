// Add XERCES & XALAN to classpath for building - we assume you're building with 1.1 or higher now
/*
def xmlJars = new File("${basedir}/lib").listFiles().findAll { it.name.endsWith("._jar") }

grailsSettings.compileDependencies.addAll xmlJars
grailsSettings.runtimeDependencies.addAll xmlJars
grailsSettings.testDependencies.addAll xmlJars
*/

grails.project.dependency.resolution = {
   inherits "global"
   
	repositories {        
        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenCentral()
        mavenRepo "http://repository.codehaus.org"
    }

    dependencies {
        compile( 'org.codehaus.groovy.modules.http-builder:http-builder:0.5.2') {
            excludes 'groovy', 'xml-apis', 'xerces'
        }
        compile( 'net.sourceforge.htmlunit:htmlunit:2.7') {
            excludes 'xml-apis', 'xerces'
        }
        compile( 'net.sourceforge.htmlunit:htmlunit-core-js:2.7') {
            excludes 'xml-apis', 'xerces'
        }
        compile( 'commons-httpclient:commons-httpclient:3.1') {
            excludes 'xml-apis', 'xerces'
        } 
        
        test( 'sac:sac:1.3') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'commons-codec:commons-codec:1.4') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'nekohtml:nekohtml:1.9.14') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'cssparser:cssparser:0.9.5') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'serializer:serializer:2.7.1') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'xalan:xalan:2.7.1') {
            excludes 'xml-apis', 'xerces'
        }
/*
        test( 'xercesImpl:xercesImpl:2.9.1') {
            excludes 'xml-apis'
        }
*/
    }

    plugins {
        runtime( ":tomcat:$grailsVersion") {
            export = false
        }
    }
}