package team4_3;

import java.sql.Connection;         //DB서버 연결
import java.sql.DriverManager;      //DB서버 연결


import java.sql.PreparedStatement;  //테이블에 SQL 실행
import java.sql.ResultSet;          //테이블에서 조회한 결과
import java.util.ArrayList;
import java.util.List;




public class ClaimHistoryDAO {

//  DB 서버 연결을 위한 드라이버, 주소 , 아이디 ,비번
	String dbDrv = "com.mysql.cj.jdbc.Driver";
//	DB 드라이버
//	String dbUrl = "jdbc:mysql://localhost:3306/javaExample?serverTimezone=Asia/Seoul";
	String dbUrl = "jdbc:mysql://codevlab.kr:3306/team4?serverTimezone=Asia/Seoul";
//    DB 주소
//	String dbUsr = "javauser";
	String dbUsr = "team4";
//  DB 아이디 
	String dbPwd = "123456";
//  DB 비번 
	
	//이력추가
	public int inserthistory(long lostItemId, long ownerClaimId) {
		int result = 0;
		String sql="""
                      insert into claim_history
                      (lost_item_id, owner_claim_id, action_date) 
                      values (?, ?, now())
                   """;
		try (																	  //코드가 끝나면 자동실행
			Connection conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);   //DB 주소 아이디 비번으로 접속
			PreparedStatement pstmt = conn.prepareStatement(sql);                 //DB와 연결된 상태에서 SQL을 실행할 수 있는 객체
		){
			pstmt.setLong(1, lostItemId);    				                      
			pstmt.setLong(2, ownerClaimId);
			
			result = pstmt.executeUpdate();										  //DB에서 실행해고 저장한다		
			
		}catch(Exception e) {                                                     //try 안의 오류 캐치 ( 어떤오류고 어디줄인지 이유까지)
			e.printStackTrace();                                                  // 에러에 대한 내용 출력
		}
		return result;
	}
	//2분실물별 이력 조회
	public List<ClaimHistoryDTO> selectAllLostItemId(long lostItemId){
		List<ClaimHistoryDTO> list = new ArrayList<>();
		String sql = """
				        select id, lost_item_id, owner_claim_id, action_date
				        from claim_history
				        Where lost_item_id=?
				        order by action_date desc
				     """;
		
		try (
	            Connection conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);  //“DB 주소 아이디 비번으로 접속”
	            PreparedStatement pstmt = conn.prepareStatement(sql);   //DB와 연결된 상태에서 SQL을 실행할 수 있는 객체
			){
			    pstmt.setLong(1, lostItemId);
         		ResultSet rs = pstmt.executeQuery();       //DB 에서 한걸 rs로 받아온다	
		
		
         		while (rs.next()) {
                    ClaimHistoryDTO chdto = new ClaimHistoryDTO(
                        rs.getLong("id"),                          //실제 테이블의 컬럼명
                        rs.getLong("lost_item_id"),                //실제 테이블의 컬럼명
                        rs.getLong("owner_claim_id"),              //실제 테이블의 컬럼명
                        rs.getTimestamp("action_date")             //실제 테이블의 컬럼명
                    );
                    list.add(chdto);
                }

                rs.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return list;
        }
	
}
