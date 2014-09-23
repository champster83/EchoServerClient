import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 12321;
  
        if (args.length == 2) {
            hostName = args[0];
            portNumber = Integer.parseInt(args[1]);
        }
 
        
        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = stdIn.readLine())!= null) {
                out.println(input);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.out.println("unrecognized host " + hostName + "\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error for the connection to " + hostName + "\n" + e.getMessage());
        }
    }
}
