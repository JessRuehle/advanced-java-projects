package edu.bloomu.homework7;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws Exception 
    {

        // create a connection to the server
        Socket server = new Socket("127.0.0.1", 3496);

        Scanner fromKeyboard = new Scanner(System.in);
        Scanner fromServer = new Scanner(server.getInputStream());
        PrintWriter toServer = new PrintWriter(server.getOutputStream(), 
                true);

        // request the user's username and return a list of active users on 
        // the server
        System.out.print("Please enter your username: ");
        String username = fromKeyboard.nextLine();
        toServer.println(username);

        ClientMsgRecipient messaging = new ClientMsgRecipient(server);
        Thread thread = new Thread(messaging);
        thread.start();

        // give user instructions on how to message another user
        System.out.println("To message another user on the server, "
                + "enter all the relevant information in the following "
                + "format:\nUsername of person you'd wish to "
                + "message/message/your username");

        do 
        {
            System.out.println(fromServer.nextLine());
        } while(true);
    }
}
