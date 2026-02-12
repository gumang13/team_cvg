package team_cvg_lostAndFound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OwnerClaimDAO {
	
    String dbDrv = "com.mysql.cj.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost:3306/tem4?serverTimezone=Asia/Seoul";
    String dbUsr = "team4";
    String dbPwd = "123456";
    
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
	    if (rs != null) { rs.close(); }
	    if (pstmt != null) { pstmt.close(); }
	    if (conn != null) { conn.close(); }
		}catch (Exception e)  {
			e.printStackTrace();
		}
	}
	// 주인 정보 등록
	public int setUpdate(OwnerClaimDTO dto) {
		int result = 0;
		
		try {
			Class.forName(dbDrv);
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			String sql = "";
			sql += "insert into owner_claim (lost_item_id, owner_name, phone, matched) values ";
			sql += "(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, dto.getLost_item_id());
			pstmt.setLong(2, dto.getOwner_claim_id());
			pstmt.setString(3, dto.getOwner_name());
			pstmt.setString(4, dto.getPhone());
			pstmt.setBoolean(5, dto.isMatched());
			result = pstmt.executeUpdate();
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	dbClose(rs, pstmt, conn);
	    }
		
		return 0;
	}
	// 주인 신청 조회
	public List<OwnerClaimDTO> selectAll() {
		List<OwnerClaimDTO> list = new ArrayList<>();
		
		try {
			Class.forName(dbDrv);
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			String sql = "SELECT * FROM owner_claim";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
                OwnerClaimDTO dto = new OwnerClaimDTO();
                dto.setOwner_claim_id(rs.getInt("owner_claim_id"));
                dto.setLost_item_id(rs.getInt("lost_item_id"));
                dto.setOwner_name(rs.getString("owner_name"));
                dto.setPhone(rs.getString("phone"));
                dto.setMatched(rs.getBoolean("matched"));
                list.add(dto);
            }
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	dbClose(rs, pstmt, conn);
	    }
		
		return list;
	}
	// 매칭 처리
	public int updateMatched(long owner_claim_id) {
		
		try {
			Class.forName(dbDrv);
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			String sql = "UPDATE owner_claim SET matched = true WHERE claim_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, owner_claim_id);
            return pstmt.executeUpdate();
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	dbClose(rs, pstmt, conn);
	    }
		
		return 0;
	}
}
