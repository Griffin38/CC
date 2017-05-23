package ReverseProxy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class stateTable {

	private HashMap<String,stateE> servers;
	
	public stateTable(){
		this.servers = new HashMap<>();
	}
	//add 
	public void addE(String IP){
		if(!servers.containsKey(IP)){
		System.out.println("Novo Servidor: "+ IP);
		this.servers.put(IP, new stateE());
	}
	}
	//actualizars
	
	public void upT(String IP,long x){
		stateE aux = servers.get(IP);
		aux.setTotal(aux.getTotal()+1);
		aux.setTimeI(x);
		
	}
	public void updateE(long rtt, int lig,String IP){
		stateE aux = servers.get(IP);
		aux.setRTT(rtt);
		aux.setNligTCP(lig);
		aux.setNentradas(aux.getNentradas()+1);
		aux.setNperdas(aux.getTotal()-aux.getNentradas());
		aux.setPercent(aux.getTotal()/aux.getNentradas());
	}
	//melhro server
	
	public String getBest(){
		String ret = new String();
		long rtt = 100000000 ;
		int con = 1000;
		//devolver rtt mais baixo ou menos ligaçoes / pacotes perdidos
		for(String s : this.servers.keySet()){
			stateE aux = servers.get(s);
			
			if(aux.getRTT() < rtt && aux.getNligTCP() == 0){
				ret = s;
				rtt = aux.getRTT();
				con = aux.getNligTCP();
				
			}else if(aux.getRTT() < rtt)  {
				if(aux.getNligTCP() < con ){
					ret = s;
					rtt = aux.getRTT();
					con = aux.getNligTCP();
				}
			}
		}
		
		
		return ret;
	}
	public List<String> getServers() {
		
		 List<String> ret = new ArrayList<String>();
		 for(String s : servers.keySet()){
			 ret.add(s);
		 }
		return ret;
	}
	public long getTi(String IP){
		stateE aux = servers.get(IP);
		return aux.getTimeI();
	}
	public void renew(){
		this.servers = new HashMap<>();
	}
}
