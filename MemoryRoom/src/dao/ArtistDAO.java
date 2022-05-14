package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Artist;

public class ArtistDAO extends DAO{
	public List<Artist> search(String keyword) throws Exception{
		// 検索結果を入れるリスト作成
		List<Artist> list = new ArrayList<>();
		
		// データベース接続
		Connection con = getConnection();
		
		// 検索ワードがあれば条件指定でDBから取得
		ResultSet rs;
		PreparedStatement st ;
		if (keyword.equals("")) {
			st = con.prepareStatement(
					"select name from artist");
			rs = st.executeQuery();
		} else {
			st = con.prepareStatement(
					"select name from artist where name like ?");
			st.setString(1, "%" + keyword + "%");
			rs = st.executeQuery();
		}
		// 検索結果をリストに入れる
		while (rs.next()) {
			Artist a = new Artist();
			a.setName(rs.getString("name"));
			list.add(a);
		}
		
		// 切断
		st.close();
		con.close();
		
		return list;
	}
	
	public Artist info(String name) throws Exception{
		// 歌手個人の情報をインスタンスで返す
		// データベース接続
		Connection con = getConnection();
		ResultSet rs;
		PreparedStatement st ;
		st = con.prepareStatement(
				"select artist.name, birthday, plice, blood, gender, introduction, lebel.name"
				+ " from artist"
				+ " left outer join plice on birthplice_id = plice.id"
				+ " left outer join blood_type on blood_type_id = blood_type.id"
				+ " left outer join gender on gender_id = gender.id"
				+ " left outer join lebel on lebel_id = lebel.id"
				+ " where artist.name like ?");
		st.setString(1, name);
		rs = st.executeQuery();
		
		Artist a = new Artist();
		rs.next();
		a.setName(rs.getString("artist.name"));
		a.setBirthDay(rs.getDate("birthday"));
		a.setBirthPlice(rs.getString("plice"));
		a.setBloodType(rs.getString("blood"));
		a.setGender(rs.getString("gender"));
		a.setIntroduct(rs.getString("introduction"));
		a.setLebel(rs.getString("lebel.name"));
		
		
		// 切断
		st.close();
		con.close();
		
		return a;
	}

}
