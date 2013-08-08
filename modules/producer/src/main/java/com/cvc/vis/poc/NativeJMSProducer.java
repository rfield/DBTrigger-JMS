package com.cvc.vis.poc;

/**
 * Created with IntelliJ IDEA.
 * User: rfield
 * Date: 8/5/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.jms.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NativeJMSProducer {

    public static void send(int messageId, String messageString) throws SQLException {

        //  Keep track of the JMS Messages we publish
        java.sql.Connection sqlConnection = DriverManager.getConnection("jdbc:default:connection:");
        String sql = "INSERT INTO JMS_AUDIT VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = sqlConnection.prepareStatement(sql);
            preparedStatement.setInt(1, messageId);
            preparedStatement.setString(2, messageString);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //  Publish a JMS Message
        try {
            javax.jms.Connection connection = null;
            Session session = null;
            MessageProducer msgProducer = null;
            Destination destination = null;

            String serverUrl = "localhost:7122";
            String userName = "user";
            String password = "passwd";
//            String destName = "queue.sample";
            String destName = "topic.sample";

            ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(serverUrl);
            connection = factory.createConnection(userName, password);

            session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
//            destination = session.createQueue(destName);
            destination = session.createTopic(destName);

            msgProducer = session.createProducer(null);

            TextMessage msg = session.createTextMessage();
            msg.setText(messageString);
            msgProducer.send(destination, msg);

            connection.close();
        } catch (JMSException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            NativeJMSProducer.send(0, "This is a test message.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
