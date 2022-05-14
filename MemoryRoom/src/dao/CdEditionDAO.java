package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cd;

public class CdEditionDAO extends DAO{
	public List<Cd> possSearch(String keyword, int possession) throws Exception{
		// 検索結果を入れるリストを作成
		List<Cd> list = new ArrayList<>();
		
		// DB接続
		Connection con = getConnection();
		ResultSet rs;
		PreparedStatement st;
		
		if (possession == 1) {
			// 所持の場合
			st = con.prepareStatement(
					"select cd.name as cd, dc.name as edition"
					+ " from cd_edition"
					+ " left outer join cd"
					+ " on cd.id = cd_id"
					+ " left outer join discography_classifition as dc"
					+ " on dc.id = cd_classifition_id"
					+ " where cd.name like ? and possession = true");
			st.setString(1, "%" + keyword + "%");
			rs = st.executeQuery();
		} else {
			// 未所持の場合
			st = con.prepareStatement(
					"select cd.name as cd, dc.name as edition"
					+ " from cd_edition"
					+ " left outer join cd"
					+ " on cd.id = cd_id"
					+ " left outer join discography_classifition as dc"
					+ " on dc.id = cd_classifition_id"
					+ " where cd.name like ? and possession = false");
			st.setString(1, "%" + keyword + "%");
			rs = st.executeQuery();
		}
		while (rs.next()) {
			Cd c = new Cd();
			c.setCdName(rs.getString("cd"));
			c.setCdEdition(rs.getString("edition"));
			list.add(c);
		}
		// 切断
		st.close();
		con.close();
		
		return list;
	}

}
