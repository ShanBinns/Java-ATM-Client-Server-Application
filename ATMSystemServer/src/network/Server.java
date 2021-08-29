/**
 * This class is responsible for handling server processes, such as accepting action and objects from client. Returns objects to client.
 * @author SBINNS
 *
 */

package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	private ServerSocket servSock;
    private Socket connection;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    
    public Server()
    {
        this.createConnection();
        this.waitForRequests();
    }
    
    public void createConnection()
    {
        try
        {
        	System.out.println("Attempting to create server socket.");
            this.servSock = new ServerSocket(8888); 
            System.out.println("Server socket succesfully created.");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();;
        }
    }
    
    
    public void configureStreams()
    {
        try
        {
            this.os = new ObjectOutputStream(connection.getOutputStream());
            this.is = new ObjectInputStream(connection.getInputStream());
            System.out.println("Server streams connected to client streams");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    public void closeStreams()
    {
        try
        {
            os.close();
            is.close();
            connection.close();
            System.out.println("Server streams closed");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    private void waitForRequests(){
        try
       {
           while (true)
           {
        	   System.out.println("Server waiting for the connections");
              connection = servSock.accept(); 
              new ServerEngine(connection);
           }
       }
       catch(IOException ex)
       {
           ex.printStackTrace();
       }
       catch(Exception ex){
    	   ex.printStackTrace();
       }
   }
	
}
