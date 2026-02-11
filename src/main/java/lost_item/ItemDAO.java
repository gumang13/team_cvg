package lost_item;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ItemDAO {
	    private String dbUrl ="jdbc:mysql://localhost:3306/team4?serverTimezone=Asia/Seoul";
        private	String dbUsr ="team4";
        private	String dbPwd ="123456";
	    private Scanner kbd = new Scanner(System.in);
        private	Connection conn= null;
  	    private PreparedStatement pstmt = null;
        private	ResultSet rs = null;
	    
        
   	 // db 종료하는 메서드
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
        
        
        public List<ItemDTO> item_list (){
     	   List<ItemDTO> list=new ArrayList<>();
     	   try {
     		   
     			Class.forName("com.mysql.cj.jdbc.Driver");
     			conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
     			//-----------------------------------------------------
     			String sql_ ="";
     			sql_="select * from lost_item ";
     		   pstmt = conn.prepareStatement(sql_);
     	   		
     		   //private String item_name;
//			private String feature;
//     			private String category;
//     			private String status;
//     			private String item_storage;
//     			private Date lost_date;
     		   
     	   		 rs = pstmt.executeQuery();
     			while (rs.next()) {  
     				     ItemDTO item= new ItemDTO();
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
        public void item_delete() {
        	System.out.println("삭제할 아이템 id를 입력하세요");
        	   long id= kbd.nextLong();
        	
        	try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
        		conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
        		//-----------------------------------------------------
        		
            	String sql ="";
    			sql += "delete * from lost_item where id=?";
    			sql += "(?)";
    			
    			pstmt = conn.prepareStatement(sql);
    			pstmt.setLong(1, id);
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
        
        
        public void item_update() {
     	   try {
     		  int result = 0;
     	   
     			Class.forName("com.mysql.cj.jdbc.Driver");
     			conn=DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
     			//-----------------------------------------------------
     			System.out.println("수정할 분실물의 id를 입력하세요");
     			long id=kbd.nextLong();
     			//이름 특징 상태 카테고리 날짜
     			System.out.println("수정할 이름을 입력하세요");
     			String name=kbd.nextLine();
     			System.out.println("수정할 특징을 입력하세요");
     			String feature=kbd.nextLine();
     			System.out.println("수정할 상태를 입력하세요(수령 미수령)");
     			String status=kbd.nextLine();
     			System.out.println("수정할 카테고리를 입력하세요");
     			String category=kbd.nextLine();
     			System.out.println("수정할 장소를 입력하세요");
     			String item_storage = kbd.nextLine();

     			String sql ="";
     			sql += "update lost_item set item_name = ?, feature = ?, status = ?, category = ? where id = ? ";
    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, name);
    			pstmt.setString(2, feature);
    			pstmt.setString(3, status);
    			pstmt.setString(4,category);
    			pstmt.setString(5,item_storage);
    			pstmt.setLong(6, id);
    		
    			result = pstmt.executeUpdate(); // 0, 1
     			if (result>0) {   
                    System.out.println("수정 성공!!");
     			}else {
     				System.out.println("수정실패..");
     			}
     	   }catch(Exception e){
     		   System.out.println("잘못된 입력입니다");
     	   }finally {
     		   dbClose(rs, pstmt, conn);
     	   }
     			
        }
        
        
        
        
        
	
	
	
	
	
}
