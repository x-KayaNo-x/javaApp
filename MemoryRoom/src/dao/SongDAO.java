package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Song;

public class SongDAO extends DAO {
	
	public List<Song> search(String keyword) throws Exception{
		List<Song> list = new ArrayList<>();
		// データベース接続
		Connection con = getConnection();
		
		// 曲に対して検索ワードなしの場合、曲情報全件取り出し
		// 検索ワードがあれば条件指定
		ResultSet rs;
		PreparedStatement st ;
		if (keyword.equals("")) {
			// 全件検索
			st = con.prepareStatement(
					// 歌手名、cd名順に取得
					"select distinct song.name, cd.name, artist.name from song"
					+ " left outer join cd_information as ci"
					+ " on song.id = song_id"
					+ " left outer join cd_edition as ce"
					+ " on cd_edition_id = ce.id"
					+ " left outer join cd"
					+ " on ce.cd_id = cd.id"
					+ " left outer join artist"
					+ " on ci.artist_id = artist.id"
					+ " order by artist.name desc, cd.name, song.name");
			rs = st.executeQuery();
		} else {
			// キーワード検索
			st = con.prepareStatement(
					"select distinct song.name, cd.name, artist.name from song"
					+ " left outer join cd_information as ci"
					+ " on song.id = song_id"
					+ " left outer join cd_edition as ce"
					+ " on cd_edition_id = ce.id"
					+ " left outer join cd"
					+ " on ce.cd_id = cd.id"
					+ " left outer join artist"
					+ " on ci.artist_id = artist.id"
					+ " where song.name like ?"
					+ " order by artist.name desc, cd.name, song.name");
			st.setString(1, "%" + keyword + "%");
			rs = st.executeQuery();
		}
		// 検索結果をリストに入れる
		while (rs.next()) {
			Song s = new Song();
			s.setSongName(rs.getString("song.name"));
			s.setCdName(rs.getString("cd.name"));
			s.setName(rs.getString("artist.name"));
			list.add(s);
		}
		
		// 切断
		st.close();
		con.close();
		
		return list;
	}

}
