package bean;

import java.util.List;

public class Cd{
//	private int cdId;					// SQL検索用id
	private String cdName;				// CD名
	private String name;				// アーティスト名
	private String cdEdition;			// エディション
	private java.util.Date release;		// 発売日
	private int price;					// 価格
	private int oriconTop;				// オリコン最高位
	private String leadSong;			// リード曲
	private String spesification;		// 仕様
	private int possession;				// 所持の有無
	private List<String> recordingSong;	// 収録曲
//	public int getCdId() {
//		return cdId;
//	}
//	public void setCdId(int cdId) {
//		this.cdId = cdId;
//	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCdEdition() {
		return cdEdition;
	}
	public void setCdEdition(String cdEdition) {
		this.cdEdition = cdEdition;
	}
	public java.util.Date getRelease() {
		return release;
	}
	public void setRelease(java.util.Date release) {
		this.release = release;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOriconTop() {
		return oriconTop;
	}
	public void setOriconTop(int oriconTop) {
		this.oriconTop = oriconTop;
	}
	public String getLeadSong() {
		return leadSong;
	}
	public void setLeadSong(String leadSong) {
		this.leadSong = leadSong;
	}
	public String getSpesification() {
		return spesification;
	}
	public void setSpesification(String spesification) {
		this.spesification = spesification;
	}
	public int getPossession() {
		return possession;
	}
	public void setPosession(int possession) {
		this.possession = possession;
	}
	public List<String> getRecordingSong() {
		return recordingSong;
	}
	public void setRecordingSong(String recordingSong) {
		this.recordingSong.add(recordingSong);
	}
}
