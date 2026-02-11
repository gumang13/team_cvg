package team_cvg_lostAndFound;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("1.주인 정보 등록, 2.매칭, 0. 프로그램 종료");
			String menu = sc.nextLine();
			OwnerClaimDTO dto = new OwnerClaimDTO();
			OwnerClaimDAO dao = new OwnerClaimDAO();
			
			int result = 0;
			
			if(menu.equals("1")) {
				System.out.println("주인 정보 등록");
			}else if(menu.equals("2")) {
				System.out.println("매칭");
			}else if(menu.equals("0")) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
	}

}
