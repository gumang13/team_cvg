package test_area;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		
		  while(true) {
		String user =kbd.nextLine();	  
		System.err.println("원하시는 메뉴를 선택하세요");
		System.err.println("1. ㅇㅇ 2. ㅇㅇ 3. ㅇㅇ 4. ㅇㅇ ");
        if(user.equals("1")) {
        	System.out.println("분실물 접수");
        }else if(user.equals("2")) {
        	System.out.println("분실물 보관 현황");
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
// while 끝 		
		
		
		  
	}
	
}