Java Trigger JMS POC
===================

Author:	Richard Field
Date:	July 2013

In legacy applications, database tables often need to participate in the well-known Observer pattern, meainng that as the data in the table changes, application code needs to be executed.
The typical programming idiom for this situation involves a database trigger associated with the table of interest. Often the trigger inserts new records into a "shadow table" whenever an update occurs. The shadow table is checked using some sort of polling mechanism, either via a brute force method like Unix cron or using a third party adapter provided by an integration platform such as the Mule ESB, Apache Camel or TIBCO BusinessWorks.

In general, Polling, or "repeated refresh", though simple, is more or less an architectural anti-pattern, despite its popularity.

This project is part of a working proof-of-concept demonstrating the use of Oracle Triggers executing a Java Procedure in order to "publish" data changes to a process running outside the database using a TIBCO JMS Topic.


See JavaTriggerPOC-DB for additional details.