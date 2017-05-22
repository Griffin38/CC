package Server;

public class Server {
		private boolean running;
		private monitorUDP u;
		private tcpServer t;
		private String connect;
		
		public Server(String c ){
			this.connect = c;
			u= new monitorUDP(connect);
			t = new tcpServer();
			u.registar(t);//mandar t 
			
		}

		public void run()  {
			running = true;
			   Thread cl = new Thread() {
				    public void run() {
	
				    		 try {
								t.runT();
							} catch (Exception e) {
								
								e.printStackTrace();
							}
				  		  
				    }  
				};

				cl.start();	
			while(running){
				u.Receive();
			}
			
		}
		
	public void close(){
		this.running = false;
	}

	 public static void main(String argv[])  {
		 Server main = new Server("localhost");
		 main.run();
	 }
}
