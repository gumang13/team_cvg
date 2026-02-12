package LostItem;


import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		LostItemDTO lostDto = new LostItemDTO();
		LostItemDAO lostDao = new LostItemDAO();
	

		  while(true) {
		System.err.println("원하시는 메뉴를 선택하세요");
		System.err.println("1. 접수 2. 조회 3. 수정 4. 삭제 5.주인정보 등록 6.주인정보 조회 7. 주인정보 수정"
				+ " 8. 주인정보 삭제 9. 수령처리 및 상태 변경 0. 프로그램 종료");
		String user =kbd.nextLine();	  
      if(user.equals("1")) {
      	System.out.println("분실물 접수");
      	
      	lostDao.item_add();
      }else if(user.equals("2")) {
      	System.out.println("분실물 보관 현황");
      List<LostItemDTO> list =	lostDao.item_list();
      for(LostItemDTO a : list) {
    	  System.out.println(a.getFeature()+"||"+a.getItem_name());
      }
      	
      	System.out.println();
      	
      }else if(user.equals("3")) {
      	System.out.println("분실물 정보 수정");
      }else if(user.equals("4")) {
      	System.out.println("분실물 정보 삭제");
      }else if(user.equals("5")) {
      	System.out.println("주인 정보 등록 및 매칭");
      }else if(user.equals("6")) {
      	System.out.println("주인 정보 조회");
      }else if(user.equals("7")) {
      	System.out.println("주인 정보 수정");
      }else if(user.equals("8")) {
      	System.out.println("주인 정보 삭제");
      }else if(user.equals("9")) {
      	System.out.println("수령 처리 및 상태 변경");
      }else if(user.equals("0")) {
      	System.out.println("프로그램 종료");
      }else {
      	System.out.println("올바르지 않은 입력입니다");
      }
	}

	}
}
