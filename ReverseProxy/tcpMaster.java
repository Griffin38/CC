package ReverseProxy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcpMaster  {

	
	public void trata(String server,Socket con){
		try {
			 Socket s = new Socket(server, 6666);
			  DataOutputStream outToClient = new DataOutputStream(con.getOutputStream());
			  DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
			  BufferedReader inFromClient = new BufferedReader(new InputStreamReader(con.getInputStream()));
			  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
			  
			  String clientSentence = inFromClient.readLine();
			  outToServer.writeBytes(clientSentence);
			  String capitalSentence = inFromServer.readLine();
			  outToClient.writeBytes(capitalSentence);
			  System.out.println("N "+ clientSentence+" C "+ capitalSentence);
			  s.shutdownInput();
	            s.shutdownOutput();
	            con.shutdownInput();
	            con.shutdownOutput();
	            s.close();
	            con.close();
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
