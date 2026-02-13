package LostItemManagement;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		OwnerClaimDAO odao = new OwnerClaimDAO();
		ItemDAO idao= new ItemDAO();
		ClaimHistoryDAO cdao = new ClaimHistoryDAO();
		
		  while(true) {
		System.err.println("원하시는 메뉴를 선택하세요");
		System.err.println("1. 분실물 접수 2. 분실물 보관현황 3. 분실물 정보 수정 4. 분실물 정보 삭제 5. 주인 정보 등록 및 매칭"+" 6. 주인정보 조회  0. 종료");
		String user =kbd.nextLine();	  
        if(user.equals("1")) {
        	System.out.println("분실물 접수");
        	idao.item_add();
        }else if(user.equals("2")) {
        	System.out.println("분실물 보관 현황");
        	List<ItemDTO> list=idao.item_list();
        	for(ItemDTO a :list) {
        		System.out.println("물건이름 : ["+a.getItem_name()+"] 물건특징 : ["+a.getFeature()+"] 물건카테고리 : ["+a.getCategory()+"] 물건상태 : ["+a.getStatus()+"] 물건입수시기 : ["+a.getLost_date()+"] 물건보관장소 : ["+a.getItemStorage()+"]");
        	}
        }else if(user.equals("3")) {
        	System.out.println("분실물 정보 수정");
        	idao.item_update();
        }else if(user.equals("4")) {
        	System.out.println("분실물 정보 삭제");
        	idao.item_delete();
        }else if(user.equals("5")) {
        	System.out.println("주인 정보 등록 및 매칭");
        	
        	odao.addOwnerClaim();     
        	
        	
        }else if(user.equals("6")) {
        	System.out.println("주인 정보 조회");
        	List<OwnerClaimDTO> list=odao.selectAll();
        	for(OwnerClaimDTO a : list) {
        		System.out.println("잃어버린 물건 id : ["+a.getLost_item_id()+"] 이름 : ["+a.getOwner_name()+"] 연락처 : ["+a.getPhone()+"]");
        	}
        }else if(user.equals("0")) {
        	System.out.println("프로그램 종료");
        }else {
      	System.out.println("올바르지 않은 입력입니다");
      }	
		
		
		
		
		
		
		
		
		
	  }
// while 끝 		
		
		
		  
	}
	
}