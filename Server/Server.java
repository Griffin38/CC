package Server;

public class Server {
		private boolean running;
		private monitorUDP u;
		private tcpServer t;
		private String connect;
		
		public Server(String c ){
			this.connect = c;
			u= new monitorUDP(connect);
			u.registar();//mandar proprio ip
			//t = new tcpServer(connect);
		}

		public void run()  {
			running = true;
			
				u.run();
				t.run();
			
			
		}
		
	public void close(){
		this.running = false;
	}
}
