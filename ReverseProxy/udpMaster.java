package ReverseProxy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class udpMaster extends Thread {
	private stateTable servidores;
	
	public udpMaster(stateTable serv) {
		servidores = serv;
		
	}
	public void perguntar(String connect){
		try{
		    DatagramSocket ds = new DatagramSocket();  
		    String str = "U:";
		 
		    InetAddress ip = InetAddress.getByName(connect);  
		     
		    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 5556);  
		    ds.send(dp);  
		    ds.close();  
	}catch (Exception e){
		e.printStackTrace();
	}
}
	public void run() {
		
		   Thread probing = new Thread() {
			    public void run() {
			    	 while (true) {
			    		 try {
			    			 for(String s : servidores.getServers()){
			    				 perguntar (s);
			    				 servidores.upT(s);
			    			 }
							TimeUnit.SECONDS.sleep(60);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
			  		 
			    	
			  		  }
			    }  
			};

			probing.start();
		
        while(true){
        	try {
   			 DatagramSocket ds = new DatagramSocket(5555);
   		    byte[] buf = new byte[1024];  
   		    DatagramPacket dp = new DatagramPacket(buf, 1024);  
   		    ds.receive(dp);  
   		    String str = new String(dp.getData(), 0, dp.getLength());  
   		  String[] split = str.split(":");
   		    switch(split[0]){
            case "D": 
            	String[] split2 = split[1].split("/");
          		 System.out.println(split2[1]);
          		   servidores.addE(split2[1]);
            break;
   case "U": String[] split3 = split[1].split("/");
	 System.out.println(split3[1]);
	 System.out.println(split[2]);
	 // falta updateE(long rtt, int lig,String IP)
            break;
   default:   System.out.println("NOpe");
            break;
   		    }
   		
   		    //se for entrar adicionar a statetable se for resposta actualizar
   		    
   		   
   		    ds.close();  
   		} catch (Exception e) {
   			e.printStackTrace();
   		}  
        }
    }
	
}
