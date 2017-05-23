package ReverseProxy;

import java.io.*;
import java.net.*;

public class ReverseProxy {

	private stateTable servidores;
	private tcpMaster TCP;
	private udpMaster UDP;
	
	public ReverseProxy(){
		this.servidores = new stateTable();
		this.TCP = new tcpMaster();
		this.UDP = new udpMaster(servidores);
		this.UDP.start();
		//TCP
	}
	
	 public static void main(String argv[]) throws Exception {
		 
		  ServerSocket MainOut = new ServerSocket(80);
		  ReverseProxy main = new ReverseProxy();
		
		  while (true) {  
			  
			  Socket connectionSocket = MainOut.accept();
	  	  
	  		   
	  		   Thread cl = new Thread() {
			    public void run() {
			    	 
			    		main.trata(connectionSocket);
			  		   //escolher e trartar novo cliente
			  		  
			  		  
			    }  
			};

			cl.start();
			
			
	 }
		 }
	 
private void trata(Socket connectionSocket){
	
		String IPx = servidores.getBest();
		TCP.trata( IPx , connectionSocket);

}
}
