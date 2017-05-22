package Server;

import java.net.*; 


public class monitorUDP  {
	private String connect;
	private String self;
	private tcpServer t;
	
	public monitorUDP(String c){
		this.connect= c;
		try {
			this.self = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	//recebe t para perguntar connects 
	public void registar(tcpServer t2){
		t = t2;
		try{
		    DatagramSocket ds = new DatagramSocket();  
		    String str = "D:" + self;  
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
		    String str = "U:"  + self +":" + t.getConnects();
		 
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
			 DatagramSocket ds = new DatagramSocket(5556);
		    byte[] buf = new byte[1024];  
		    DatagramPacket dp = new DatagramPacket(buf, 1024);  
		    ds.receive(dp);  
		    String str = new String(dp.getData(), 0, dp.getLength()); 
		    
		    System.out.println(str); 
		    ds.close(); 
		    this.responder();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}  
	
	}
	

}