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
		//devolver rtt mais baixo ou menos ligaçoes / pacotes perdidos
		
		
		
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
