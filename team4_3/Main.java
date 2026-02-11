package team4_3;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ClaimHistoryDAO chdao = new ClaimHistoryDAO();
		
		while(true) {
			System.out.println("[ 1.수령 처리 ] [ 2.처리이력 조회 ] [ 0.종료 ]");
			System.out.print("숫자입력 : ");
			String num = sc.nextLine();
			
			
			if(num.equals("1")) {
				System.out.println("수령처리");
			
				ClaimHistoryDTO dto = new ClaimHistoryDTO();
				dto.inputClaimHistory();
				
				int result = chdao.inserthistory(
						dto.getLostItemId(), 
						dto.getOwnerClaimId()
						);

			    if(result > 0) {
			        System.out.println(" 수령 처리 완료");
			    } else {
			        System.out.println(" 수령 처리 실패");
			    }
				
				
				
				
				
			}else if(num.equals("2")) {
				System.out.println("처리이력 조회");
				System.out.print("조회할 분실물 ID: ");
				
				long findid = sc.nextLong();
				sc.nextLine();
				
				List<ClaimHistoryDTO> list = chdao.selectAllLostItemId(findid);
				
				System.out.println("id , 분실물ID , 클레임ID , 날짜");
				for(ClaimHistoryDTO chdto : list) {
					chdto.print();
				}
				
			}else if(num.equals("0")) {
				System.out.println("종료");
				break;
			}else {
				System.out.println("올바르지 않은 입력입니다.");
			}
		}
		sc.close();
	}

}
