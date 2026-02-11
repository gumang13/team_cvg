package LostItem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LostItemDAO {

	private String dbUrl = "jdbc:mysql://codevlab.kr:3306/team4?serverTimezone=Asia/Seoul";
	private String dbUsr = "team4";
	private String dbPwd = "123456";
	private Scanner kbd = new Scanner(System.in);
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
    public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
 		try {
 			if(rs!=null) {rs.close();}
 			if(pstmt!=null) {pstmt.close();}
 			if(conn!=null) {conn.close();}
 		}catch(Exception e) {
 			e.printStackTrace();
 		}
 		
 	}
	
    public void item_add() {
        
    	System.out.println("분실물 이름을 입력하세요");
    	String item_name=kbd.nextLine();
    	System.out.println("분실물 특징을 입력하세요");
    	String feature=kbd.nextLine();
    	System.out.println("분실물 카테고리를 입력하세요(지갑,핸드폰,가방,기타)");
    	String category=kbd.nextLine();
    	System.out.println("분실물 보관 장소를 입력하세요");
    	String item_storage=kbd.nextLine();
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
		//-----------------------------------------------------
		
    	String sql ="";
		sql += "insert into lost_item(item_name,feature,category,status,lost_date,item_storage) values";
		sql += "(?,?,?,?,now(),?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, item_name);
		pstmt.setString(2, feature);
		pstmt.setString(3, category);
		pstmt.setString(4, "보관");
		pstmt.setString(5, item_storage);
	    int result=0;
		result =pstmt.executeUpdate();
		if(result==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
    	}catch(Exception e) {
    		
    	}finally {
    		dbClose(rs, pstmt, conn);
    	}
    }
    
    
    public List<LostItemDTO> item_list (){
  	   List<LostItemDTO> list=new ArrayList<>();
  	   try {
  		   
  			Class.forName("com.mysql.cj.jdbc.Driver");
  			conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
  			//-----------------------------------------------------
  			String sql_ ="";
  			sql_="select * from lost_item ";
  		   pstmt = conn.prepareStatement(sql_);
  	   		 rs = pstmt.executeQuery();
  			while (rs.next()) {  
  				     LostItemDTO item= new LostItemDTO();
  				     item.setItem_name(rs.getString("item_name")); 
  				     item.setFeature(rs.getString("feature"));
  				     item.setCategory(rs.getString("category"));
  				     item.setStatus(rs.getString("status"));
  				     item.setItemStorage(rs.getString("item_storage"));
  				     item.setLost_date(rs.getDate("lost_date"));
  				     
                         list.add(item);
  			}		
  	   }catch(Exception e) {
  		   
  	   }finally {
  		   dbClose(rs, pstmt, conn);
  	   }return list;
  	   
     }
    


}
