# RestFull-Person-App-jersey-version1

A simple Java EE7(JAX-RS)application that:

-get one object/multiple objects from Hashtable

-update data from Hashtable

-delete data from Hashtable




# Prerequisites
JDK 8
Maven 3.0.3 or newer



# Test
mvn clean install -DskipTests



# Generate War and add it on Tomcat9/webapps
war:war org.codehaus.mojo:wagon-maven-plugin:upload-single -Dwagon.fromFile=C:\yourFilePosition\RestController-1.0-SNAPSHOT.war -Dwagon.url=file://C:\yourTomcatPosition\apache-tomcat-9.0.71\webapps\

