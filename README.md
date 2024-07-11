
Spring Boot Actuator & Admin Server
==================================
<pre>
*)Actuator :Production Ready Endpoints in simple they are ready made services which are used
            at production server manily
			
&#8594; Add below dependency
    spring-boot starter-actuator
	
&#8594; It provides default services : health,info
<pre>
<b>a)health: basic application details. application status, memory details...etc</b>
<b>b)info : key-val based information (Meta data: project name,version,author,client,,,,etc)</b>


To enable other endpoints:
mangement.endpoints.web.exposure.incude=info,beans,health,metrics.configprops
      ---or---
mangement.endpoints.web.exposure.incude=*

application.properties
======================
spring.application.name=ActuactorSampleTest

#default is actuator
management.endpoints.web.base-path=/myservices

info.my.app.title=ram
info.my.app.version=3.3GA
info.my.service.data=PCF
info.my.admin.code=Ramu


#management.endpoint.health.show-details=always

mangement.endpoints.web.exposure.incude=info,beans,health,metrics.configprops
      ---or---
mangement.endpoints.web.exposure.include=*  
---------------------------------------

=>Eo exposeAll enpoints use below key in properties file 

mangement.endpoints.web.exposure.include=*  

<b>c)mappings: This endpoint provides path details, method Type, params and returnType
              of restcontroller method</b>
			  
			  Example: Testcontroller
			  Details: GET /prod/find,,,etc
			  
			  
URL:    http://localhost:8080/actuator/mappings

<b>d) beans : This endpoint provide details of all objects created in spring container.
          it even provides scope, dependency details, file location.</b>
		  
URL: http://localhost:8080/actuator/beans

<b>e)configprops: This endpoint is used to find what are key-val are loaded into
              Spring conatiner using @ConfigurationProperties annotation.</b>
			 
URL: http://localhost:8080/actuator/configprops
  
**)Note By default every endpoint contains one common path ie called base-path /actuator
        to modigy badse path use below key:
		management.endpoints.web.base-path=/myservices
		
<b>Q)Can we set base path for actuator as just "/" symbol</b>
A) No. we have to provide few chars for base path
   Example:management.endpoints.web.base-path=/myservices
<b>Q)How can we expose few selected endpoints instead of exposing all in actuators?</b>
A) Use key management.endpoints.web.exposure.include and provide selected endpoint names
   Ex:
   management.endpoints.web.exposure.include=info,beans,env,metrics,configprops
   
<b>G)scheduledtasks: This endpoint is used to find details of scheduling configured in application</b>
 URL:
 http://localhost:8080/actuator/scheduledtasks
</pre>
 
 
 <pre>
 <b>Spring Boot-Actuator-Admin</b>
 <b>=============================</b>
 Spring boot admin (Server and Client) is used to show actuator data of multiple
 microservices in visual mode(UI format)
 
 =>For this every MS application should have admin client dependency
 =>Need to create single application (one project)as admin server
 =>Provide admin server URL in every MS application 
 
      spring.boot.admin.client.url=http://localhost:8081
	 
-----Steps for coding-----------
1.Create Admin server application
name: SpringBootAdminServer
Sep: Spring boot admin server

2.At starter calss: @EnableAdminServer

3.application.properties
  server.port=9191
  
4.Create Miroservice application and below dependencies extra
  Dep:Actuator,Spring boot admin client
  
5.Inside application properties add below key extra
   spring.boot.admin.client.url=http://localhost:9191
   
6.Now Run admin server and MS application
7.Enter URL :http://localhost:9191/
8.click on application name
 </pre>
