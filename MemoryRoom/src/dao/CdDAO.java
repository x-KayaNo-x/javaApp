package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cd;

public class CdDAO extends DAO {
	/**
	 * 機能: キーワード検索・指定なし(2),所持(1),未所持(0)の判定(未実装)付き
	 * @param keyword
	 * @param possession
	 * @return List<Cd>
	 * @throws Exception
	 */
	public List<Cd> search(String keyword) throws Exception{
		// 検索結果を入れるリスト作成
		List<Cd> list = new ArrayList<>();
		
		// データベース接続
		Connection con = getConnection();
		ResultSet rs;
		PreparedStatement st ;
		// 指定なしの場合
		st = con.prepareStatement(
			"select name as cd from cd where name like ?");
		st.setString(1, "%" + keyword + "%");
		rs = st.executeQuery();
		// cd名のみの検索結果をリストに入れる
		while (rs.next()) {
			Cd c = new Cd();
			c.setCdName(rs.getString("cd"));
			list.add(c);
		}
		// 切断
		st.close();
		con.close();
		
		return list;
	}
	

	
	public List<Cd> info(String name) throws Exception{
		// 検索結果を入れるリスト作成
		List<Cd> list = new ArrayList<>();
		
		// データベース接続
		Connection con = getConnection();
		ResultSet rs;
		PreparedStatement st ;
		// urlから飛んでくる想定(完全一致)
		st = con.prepareStatement(
				  "select cd.name, artist.name, dc.name, cd.release_date,"
				+ " ce.price, cd.oricon_top, song.name, ce.specification, ce.possession"
				+ " from cd"
				+ " left outer join artist on artist_id = artist.id"
				+ " left outer join song on lead_song_id = song.id"
				+ " left outer join cd_edition as ce on cd.id = cd_id"
				+ " left outer join discography_classifition as dc on cd_classifition_id = dc.id"
				+ " where cd.name like ?"
				+ " order by dc.id"
				);
		st.setString(1, name);
		rs = st.executeQuery();
		
		while (rs.next()) {
			Cd c = new Cd();
			c.setCdName(rs.getString("cd.name"));
			c.setName(rs.getString("artist.name"));
			c.setCdEdition(rs.getString("discography_classifition.name"));
			c.setRelease(rs.getDate("cd.release_date"));
			c.setPrice(rs.getInt("cd_edition.price"));
			c.setOriconTop(rs.getInt("cd.oricon_top"));
			c.setLeadSong(rs.getString("song.name"));
			c.setSpesification(rs.getString("cd_edition.specification"));
			c.setPosession(rs.getInt("cd_edition.possession"));
			list.add(c);
		}
		
		
		// 切断
		st.close();
		con.close();
		
		return list;
	}

}

