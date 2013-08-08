# 'cd' to the project's lib directory where there is a copy of the required TIBCO libs for convenience
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose jms.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose slf4j-api-1.4.2.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose slf4j-simple-1.4.2.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibcrypt.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibemsd_sec.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibjms.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibjmsadmin.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibjmsapps.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibjmsufo.jar
call loadjava -user rfield/rfield@10.251.229.40:1521:SDGDB1 -resolve -thin -force -verbose tibrvjms.jar
