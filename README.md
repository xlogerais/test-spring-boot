# Test Spring Boot

## Usage

1. ADD a certificate
    1. CREATE OR GET a SSL certificate
    1. PLACE the certificate in a **PKCS12**(.p12) file called **dummy.p12**
    1. PLACE the **PKCS12** file in:
        - [helloworld-api/src/main/resources/keystore](apps/helloworld-api/src/main/resources/keystore)
        - [helloworld-api-2/src/main/resources/keystore](apps/helloworld-api-2/src/main/resources/keystore)
1. START Spring services
    1. BUILD&START the Eureka server
    1. BUILD&START the config server
    1. [OPTIONAL] BUILD&START the Spring Admin server
1. START dummy services
    1. BUILD&START hello-world-api server
    1. BUILD&START hello-world-api-2 server
    1. BUILD&START hello-world-client server
1. TEST
    1. SEND successive **HTTP GET** request on http://localhost:8079 to see Ribbon choosing each of the available instances of hello-world-api through a secure **HTTPS** request
    1. SEND successive **HTTPS GET** request on https://localhost:8080/reply (hello-world-api) to see Ribbon choosing each of the available instances of hello-world-client through a **HTTP** request
    1. SEND successive **HTTPS GET** request on https://localhost:8081/reply (hello-world-api-2) to see Ribbon choosing each of the available instances of hello-world-client through a **HTTP** request


## Ports settings
- 8079: hello-world-client
- 8080: hello-world-api
- 8081: hello-world-api-2
- 8761: eureka
- 8888: spring cloud config
- 9090: spring admin
