package LostItemManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class OwnerDAO {
	    private String dbUrl ="jdbc:mysql://codevlab.kr:3306/team4?serverTimezone=Asia/Seoul";
        private	String dbUsr ="team4";
        private	String dbPwd ="123456";
	    private Scanner kbd = new Scanner(System.in);
        private	Connection conn= null;
	    private PreparedStatement pstmt = null;
        private	ResultSet rs = null;
	     
        
        //주인 확인 관리  < -- 아이템 이름 카테고리 특징등을 입력후 비교해서 매칭을 시켜줌 
        // 이후에 lost_item 테이블에 가서 status부분을 수령으로 변경 , claim_history에 등록
        
        public void findOwner(){
        	int result=0;
        	System.out.println("찾는 물건의 이름을 입력하세요");
        	 String item_name=kbd.nextLine();
        	System.out.println("찾는 물건의 특징을 입력하세요");
        	String feature=kbd.nextLine();
        	System.out.println("찾는 물건의 카테고리를 입력하세요");
        	String category=kbd.nextLine();
        	
        	// 비교 후 결과 있음 or 없음 
        	
        	if(result==0) { 
        		System.out.println("값을 변수에 담고 값이 있으면 진행 없으면 진행 x else부분에서 진행");
        	}else {
        		System.out.println("대충 쿼리문써서 status 바꾸는 내용");  //메서드로 만들기
        		System.err.println("대충 쿼리문 써서 claim_history 등록하는 내용");// 메서드로 만들기
        	}
        	
        	
        	
        	
        }
        
        
        
        
        
	
}
