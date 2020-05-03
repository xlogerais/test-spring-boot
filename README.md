# Test Spring Boot

## Usage

1. CREATE OR GET a SSL certificate
1. PLACE the certificate in a **PKCS12**(.p12) file called **dummy.p12**
1. PLACE the PKCS12 file in: **helloworld-api/src/main/resources/keystore** and **helloworld-api-2/src/main/resources/keystore**
1. BUILD&START the Eureka server
1. BUILD&START the config server
1. BUILD&START helloworld-api server
1. BUILD&START helloworld-api-2 server
