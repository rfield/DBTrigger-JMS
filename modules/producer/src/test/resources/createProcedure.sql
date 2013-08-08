CREATE OR REPLACE
PROCEDURE JMS_SEND (
  id    NUMBER,
  message VARCHAR2
)
as language JAVA
NAME 'com.cvc.vis.poc.NativeJMSProducer.send(int, java.lang.String)';