package edu.bloomu.homework7;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ChatServer 
{
    public static void main(String[] args) 
    {
        // hashmap to hold the list of users on the server
        HashMap<String, Socket> roster = new HashMap<String, Socket>();

        try 
        {
            // connects the server to the port and accepts the client's
            // connection
            ServerSocket server = new ServerSocket(3496);

            do 
            {

                Socket client = server.accept();

                ServerMsgProcessor messaging = new ServerMsgProcessor(client,
                        roster);
                Thread thread = new Thread(messaging);
                thread.start();


            } while (true);
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }

    }
}