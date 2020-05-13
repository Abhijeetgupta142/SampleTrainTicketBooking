package test;
import java.io.*;
@SuppressWarnings("serial")
public class TrainBean implements Serializable {
	private String tNo, tName, fStation, tStation;
	private int Avl;
	public TrainBean() {}
	public String gettNo() {
		return tNo;
	}
	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	public String getfStation() {
		return fStation;
	}
	public void setfStation(String fStation) {
		this.fStation = fStation;
	}
	public String gettStation() {
		return tStation;
	}
	public void settStation(String tStation) {
		this.tStation = tStation;
	}
	public int getAvl() {
		return Avl;
	}
	public void setAvl(int avl) {
		Avl = avl;
	}
}
