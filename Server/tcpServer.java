package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import ReverseProxy.ReverseProxy;

public class tcpServer{

private boolean running;
private static int con ;


public tcpServer(){
	con = 0; 
	running = false;
}
	public void runT() throws Exception{
		 running  = true;
		 con = 0;
		 ServerSocket MainOut = new ServerSocket(6666);
		
		  while (running) {  
			  
			  Socket connectionSocket = MainOut.accept();
			  con++;
	  	      
	  		   
	  		   Thread cl = new Thread() {
			    public void run() {
			    	 
			    		trata(connectionSocket);
			  		  
			  		  
			    }  
			};

			cl.start();
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
					   con--;
					   connectionSocket.shutdownOutput();
					   connectionSocket.close();
					  
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		  
		  public int getConnects(){
			  return this.con;
		  }
			public void close(){
				this.running = false;
				
			}
}
