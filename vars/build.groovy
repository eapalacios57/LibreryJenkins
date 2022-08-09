def build(Map params){
    sh """
        if [ -f Settings.xml ] ; then rm Settings.xml ; fi
        
        echo '<?xml version="1.0" encoding="UTF-8"?>' >> Settings.xml
        echo '<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 http://maven.apache.org/xsd/settings-1.2.0.xsd">' >> Settings.xml
        echo '	<mirrors>' >> Settings.xml
        echo '		<mirror>' >> Settings.xml
        echo '			<id>insecure-repo</id>' >> Settings.xml
        echo '			<mirrorOf>external:http:*</mirrorOf>' >> Settings.xml
        echo '			<url>http://10.1.0.184:3005/artifactory/simon-maven-repo/</url>' >> Settings.xml
        echo '			<blocked>false</blocked>' >> Settings.xml
        echo '		</mirror>' >> Settings.xml
        echo '	</mirrors>' >> Settings.xml
        echo '</settings>' >> Settings.xml
        mvn clean package -P${params.profile} --settings Settings.xml
        """
}