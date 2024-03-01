package edu.bloomu.homework7;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMsgRecipient implements Runnable 
{

    private Scanner fromKeyboard;
    private PrintWriter toServer;

    public ClientMsgRecipient(Socket server) 
    {
        try 
        {
            // create ways to communicate with the user and the server
            fromKeyboard = new Scanner(System.in);
            toServer = new PrintWriter(server.getOutputStream(), true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run()
    {

        do 
        {
           // retrieve the message from the keyboard and send it to the server
           toServer.println(fromKeyboard.nextLine());

        } while (fromKeyboard.hasNext());

    }
}