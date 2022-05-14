package bean;

public class Song{
//	private int songId;				// SQL検索用曲番
	private String songName;		// 曲名
	private String cdName; 			// 収録CD
	private String name;			// アーティスト名
//	public int getSongId() {
//		return songId;
//	}
//	public void setSongId(int songId) {
//		this.songId = songId;
//	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
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
	
}