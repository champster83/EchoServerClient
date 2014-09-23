import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException
    {
    	ServerSocket serverSocket = null;
    	Socket clientSocket = null;
        int portNumber = 12321;
        if(args.length == 1)
        {                    
            portNumber = Integer.parseInt(args[0]);
        }
        try
        {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server running on port: " + portNumber);
            while(true){
	            clientSocket = serverSocket.accept();
	            System.out.println("Connected to client on port: " + clientSocket.getPort());
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
	            String input = null;
	            while(true){
	            	try{
		                input = in.readLine();	
		                out.println(input.toUpperCase());
	            	}
	            	catch(Exception e)
	            	{
	            		break;
            		}
	            }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error trying to listen on port " + portNumber);
            System.out.println(e.getMessage());
        }
        finally
        {
        	clientSocket.close();
        	serverSocket.close();
        }
    }
}
