# circuit-breaker-sample
Requires to build and run the `hello-world` service first.

`curl -i http://localhost:8080/api`

`{"id":1,"message":"Hello World!","version":"1.0.0","hostName":"DESKTOP-SRL34UR"}`

Now build and run the `circuit-breaker` service.

`curl -i http://localhost:8080/api`

Returns the same content, since `circuit-breaker` delegates the call to `hello-world`

Now kill the `hello-world` service and invoke the `circuit-breaker` service again.

`curl -i http://localhost:8080/api`

This time, as per annotation `@HystrixCommand(fallbackMethod = "fallback")`, the fallback mechanism of the circuit breaker pattern delegates to the `fallback` method  

`Hello World Fallback!`

