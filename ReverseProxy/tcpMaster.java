package ReverseProxy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpMaster extends Thread {

	
	public void run() {
		try{
		ServerSocket MainOut = new ServerSocket(1337);
		  
		
		  while (true) {  
			  
			  Socket connectionSocket = MainOut.accept();
	  	      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	  		   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	  		   
	  		   Thread cl = new Thread() {
			    public void run() {
			    	 trata(connectionSocket);
			    }  
			};

			cl.start();
			
			
	 }
	}catch (Exception e){
		e.printStackTrace();
	}
	}
	
	
	private static void trata(Socket connectionSocket){
		
		try {
			  BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	  		   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			String clientSentence = inFromClient.readLine();
			 System.out.println("Received: " + clientSentence);
			 String  capitalizedSentence = clientSentence.toUpperCase() + '\n';
			   outToClient.writeBytes(capitalizedSentence);
			   
			   connectionSocket.close();
			  
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
