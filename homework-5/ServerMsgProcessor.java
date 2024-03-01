package edu.bloomu.homework7;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.StringBuilder;

public class ServerMsgProcessor implements Runnable 
{
    public Socket client;
    public HashMap<String, Socket> roster;
    private final Scanner input;
    private final PrintWriter output;

    public ServerMsgProcessor(Socket client, HashMap roster) throws Exception 
    {
        // collects information from client
        input = new Scanner(client.getInputStream());
        // sends information back to client
        output = new PrintWriter(client.getOutputStream(), true);
        this.client = client;
        this.roster = roster;
    }

    @Override
    public void run() 
    {
        try 
        {

            // grab the client's username from the input
            String username = input.nextLine();

            // if the username is not already on the roster, add it with 
            // their socket number and print the list of users to the client
            if (!roster.containsKey(username)) 
            {
                roster.put(username, client);
                String users = "";

                // send the list of users to the client server
                output.println("List of users currently online:");
                for (String name : roster.keySet()) 
                {
                    users += name + "/";
                }
                output.println(users);
            }


            do 
            {
                // retrieve the message from the client
                StringBuilder line = new StringBuilder(input.nextLine());

                // get the indices of the slashes to tokenize the information 
                // the user entered
                int firstSlash = line.indexOf("/");
                int secondSlash = line.lastIndexOf("/");
                String user = line.substring(0, firstSlash);
                String message = line.substring(firstSlash + 1, secondSlash);

                output.println(message);

            } while (input.hasNext());

        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}