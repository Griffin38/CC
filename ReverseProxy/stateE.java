package ReverseProxy;

public class stateE {
	/*
	 * rtt
	 * Nperdas
	 * NligTCP
	 * IP
	 * Total
	 * percent
	 */
	
	private long RTT, Percent;
	private int Nentradas,Nperdas,NligTCP,Total;
	
	
	
	
	public stateE() {
		this.RTT = 0;
		this.Percent = 0;
		this.Nentradas = 0;
		this.Nperdas = 0;
		this.NligTCP = 0;
		this.Total = 0;
	}
	
	public long getRTT() {
		return RTT;
	}
	public void setRTT(long rTT) {
		RTT = rTT;
	}
	public long getPercent() {
		return Percent;
	}
	public void setPercent(long percent) {
		Percent = percent;
	}
	public int getNentradas() {
		return Nentradas;
	}
	public void setNentradas(int nentradas) {
		Nentradas = nentradas;
	}
	public int getNperdas() {
		return Nperdas;
	}
	public void setNperdas(int nperdas) {
		Nperdas = nperdas;
	}
	public int getNligTCP() {
		return NligTCP;
	}
	public void setNligTCP(int nligTCP) {
		NligTCP = nligTCP;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	
}
