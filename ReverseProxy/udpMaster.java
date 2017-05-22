package ReverseProxy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpMaster extends Thread {
	private stateTable servidores;
	public udpMaster(stateTable serv) {
		servidores = serv;
		
	}

	public void run() {
		
		   Thread probing = new Thread() {
			    public void run() {
			    	 while (true) {
			    		//sleep()
			  		  // perguntar a todos 
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
   		    System.out.println(str);
   		    //processar string
   		    //se for entrar adicionar a statetable se for resposta actualizar
   		    ds.close();  
   		} catch (Exception e) {
   			e.printStackTrace();
   		}  
        }
    }
	
}
