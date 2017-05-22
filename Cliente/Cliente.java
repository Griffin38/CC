package Cliente;
import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws IOException, InterruptedException {      
        try ( 
            Socket s = new Socket("localhost", 80)) {
            String pedido;
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(s.getOutputStream());
            
          
            while( !(pedido=userInput.readLine()).equals("logout") ){
                output.println(pedido);
                output.flush();
            }   
            
            s.shutdownInput();
            s.shutdownOutput();
            s.close();
        }
 } 
}
