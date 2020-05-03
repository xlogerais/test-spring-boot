# Test Spring Boot

## Usage

1. _Create or get_ a SSL certificate
1. _Place_ the certificate in a _PKCS12_(.p12) file called _dummy.p12_
1. _Place_ the PKCS12 file in: _helloworld-api/src/main/resources/keystore_ and _helloworld-api-2/src/main/resources/keystore_
1. _Build and start_ the Eureka server
1. _Build and start_ the config server
1. _Build and start_ helloworld-api server
1. _Build and start_ helloworld-api-2 server
