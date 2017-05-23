
import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws IOException, InterruptedException {      
        try ( 
            Socket s = new Socket("localhost", 80)) {
            String pedido;
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(s.getOutputStream());
            
            DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
            String sx = "minimo\n";
            outToServer.writeBytes(sx);
            BufferedReader inFromServer= new BufferedReader(new InputStreamReader(s.getInputStream()));
            String result = inFromServer.readLine();
            System.out.println(result);
             
            
            s.shutdownInput();
            s.shutdownOutput();
            s.close();
        }
 } 
}
