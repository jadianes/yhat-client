yhat-client
===========

A java client for yhat models..

### Usage

We can query yhat models in a few simple steps.

1. Instantiate the class `YhatConfiguration` with the yhat account configuration.  
2. Pass the previous instance to the class [`YhatClientBasic`](https://github.com/jadianes/yhat-client/blob/master/src/main/java/me/jadianes/yhat/client/basic/YhatClientBasic.java).  
3. If you want just raw JSON response you're done. Call the method `predictRaw` passing the input as a `Map`.  

If we want Object-mapped responses, we have to use the method `predict`, passing as well a `Map` input, and the `class`
of the entitiy that extends `Prediction` and that will map the JSON response of the yhat model prediction.  

An example of this usage can be seen in the unit tests. Right now this is a custom-model test that will not pass
without the right credentials. Proper unit and integrations tests are part of the future works.

