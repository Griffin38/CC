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
private int con ;


public tcpServer(){
	con = 0; 
	running = false;
}
	public void runT() throws Exception{
		 running  = true;
		 con = 0;
		 ServerSocket MainOut = new ServerSocket(666);
		
		  while (running) {  
			  
			  Socket connectionSocket = MainOut.accept();
			  con++;
	  	      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	  		   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	  		   
	  		   Thread cl = new Thread() {
			    public void run() {
			    	 while (true) {
			    		trata(inFromClient,outToClient);
			  		  
			  		  }
			    }  
			};

			cl.start();
	}
	}  
		  
		  private static void trata(BufferedReader in, DataOutputStream out){
				try {
					String clientSentence = in.readLine();
					//escrever de volta 
					//con--;
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
