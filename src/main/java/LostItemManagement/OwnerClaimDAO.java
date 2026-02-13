package LostItemManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OwnerClaimDAO {
	
    String dbDrv = "com.mysql.cj.jdbc.Driver";
    String dbUrl = "jdbc:mysql://codevlab.kr:3306/team4?serverTimezone=Asia/Seoul";
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
	

	 // 입력받은 정보의 아이템이 있는지 ?   이름 , 특징 ,카테고리 
	 public String[] item_exist(String name, String feature, String category){
		 boolean isExist=false;
		 String[] result=null;
		
		 try {
				Class.forName(dbDrv);
				conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				String sql = "";
				sql += "select * from lost_item where item_name = ? and feature = ? and category = ?";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,feature);
				pstmt.setString(3,category);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = new String[2]; 
	                result[0] = String.valueOf(rs.getLong("id")); 
	                result[1] = rs.getString("status");        
				}
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		    } catch(Exception e) {
		    	e.printStackTrace();
		    } finally {
		    	dbClose(rs, pstmt, conn);
		    }
				 return result;
	 }
	
	 
	public long addOC(Long lost_item_id, String owner_name,String phone) {
		                                          //3. owner_claim 등록 후 등록된 id를 반환함
            long id=-1;
             
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
    		//-----------------------------------------------------
    		
        	String sql ="";
			sql += "insert into owner_claim(lost_item_id,owner_name,phone) values";
			sql += "(?,?,?)";
			
			pstmt = conn.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, lost_item_id);
			pstmt.setString(2,owner_name);
			pstmt.setString(3, phone);
			int result=0;
			result=pstmt.executeUpdate();
			
		    if(result>0) {
		    	rs=pstmt.getGeneratedKeys();
		    	if(rs.next()) {
		    		id=rs.getLong(1);
		    	}
		    }
			
		
        	}catch(Exception e) {
        		
        	}finally {
        		dbClose(rs, pstmt, conn);
        	}
		return id;
	} 
	
	
	public void changeStatus(long id) {          //아이템 상태 바꾸기
		
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
    		//-----------------------------------------------------
    		
    		String sql ="";
    		
 			sql += "update lost_item set status = ? where id = ? ";
 			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "수령");
			
			pstmt.setLong(2, id);
			
		    int result=0;
			result =pstmt.executeUpdate();
		
        	}catch(Exception e) {
        		
        	}finally {
        		dbClose(rs, pstmt, conn);
        	}
		
	}
      //claim history에 등록하기
	
	public void addClaimHistory(long item_id , long claim_id) {
		
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
    		//-----------------------------------------------------
    		
        	String sql ="";
			sql += "insert into claim_history(lost_item_id,owner_claim_id,action_date) values";
			sql += "(?,?,now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, item_id);
			pstmt.setLong(2, claim_id);
			
			
		    int result=0;
			result =pstmt.executeUpdate();
			if(result==1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
        	}catch(Exception e) {
        		e.printStackTrace();
        	}finally {
        		dbClose(rs, pstmt, conn);
        	}
	}
	
	// 합치기 
	public void addOwnerClaim() {
		    Scanner kbd=new Scanner(System.in);
		      System.out.println("찾을 물건의 이름을 입력하세요"); 
		      String item_name=kbd.nextLine();
		      System.out.println("찾을 물건의 특징을 입력하세요"); 
		      String feature=kbd.nextLine(); 
		      System.out.println("찾을 물건의 카테고리를 입력하세요"); 
		      String category=kbd.nextLine();
		   
		  String[] exist_ =item_exist(item_name,feature,category);
		  if(exist_ !=null) {
			  String item_id_=exist_[0];
			  Long item_id =Long.parseLong(item_id_);
			  String exist = exist_[1];
		   if(exist.equals("보관"))	  {
			  System.out.println("이름을 입력하세요");
			  String name=kbd.nextLine();
			  
			  System.out.println("전화번호를 입력하세요");
			  String phone=kbd.nextLine();
		       Long Claim_id=addOC(item_id,name,phone);
		       changeStatus(item_id);
		       addClaimHistory(item_id, Claim_id);
		        System.out.println("성공!");
		
			  
			  
			  
		   }
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
                dto.setOwner_claim_id(rs.getInt("id"));
                dto.setLost_item_id(rs.getInt("lost_item_id"));
                dto.setOwner_name(rs.getString("owner_name"));
                dto.setPhone(rs.getString("phone"));
               
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