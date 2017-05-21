package Server;

import java.net.*; 


public class monitorUDP {
	private String connect;
	
	public monitorUDP(String c){
		this.connect= c;
	}
	public void registar(){
		try{
		    DatagramSocket ds = new DatagramSocket();  
		    String str = "Welcome java";  
		    // manda IP
		    InetAddress ip = InetAddress.getByName(connect);  
		     
		    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 5555);  
		    ds.send(dp);  
		    ds.close();  
	}catch (Exception e){
		e.printStackTrace();
	}
}
 
	public void responder(){
		try{
		    DatagramSocket ds = new DatagramSocket();  
		    String str = "IM BOSS";  
		 
		    InetAddress ip = InetAddress.getByName(connect);  
		     
		    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 5555);  
		    ds.send(dp);  
		    ds.close();  
	}catch (Exception e){
		e.printStackTrace();
	}
}
	public void Receive(){
		
		try {
			 DatagramSocket ds = new DatagramSocket(5555);
		    byte[] buf = new byte[1024];  
		    DatagramPacket dp = new DatagramPacket(buf, 1024);  
		    ds.receive(dp);  
		    String str = new String(dp.getData(), 0, dp.getLength());  
		    System.out.println(str); 
		    
		    this.responder();
		    ds.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	public void run(){
		this.registar();
		//thread do receive
		this.Receive();
	}
}