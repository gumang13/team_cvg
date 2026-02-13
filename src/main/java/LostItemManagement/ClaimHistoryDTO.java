package LostItemManagement;
import java.sql.Timestamp;
import java.util.Scanner;

public class ClaimHistoryDTO {

	private long id;
	private	long lostItemId;
	private long ownerClaimId;
	private Timestamp date;
	
	public ClaimHistoryDTO() {
		
	}
	
	public ClaimHistoryDTO(long id, long lostItemId, long ownerClaimId, Timestamp date) {
		
		this.id = id;
		this.lostItemId = lostItemId;
		this.ownerClaimId = ownerClaimId;
		this.date = date;
	}

	public void inputClaimHistory() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("분실물ID : ");
		this.lostItemId = sc.nextLong();
		System.out.print("분실주인ID : ");
		this.ownerClaimId = sc.nextLong();
	}

	public void print() {
	    System.out.printf("%d | %d | %d | %s%n",
	            this.id,
	            this.lostItemId,
	            this.ownerClaimId,
	            this.date);
	}
	


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	
	public long getLostItemId() {
		return lostItemId;
	}
	public void setLostItemId(long lostItemId) {
		this.lostItemId = lostItemId;
	}
	
	
	
	public long getOwnerClaimId() {
		return ownerClaimId;
	}
	public void setOwnerClaimId(long ownerClaimId) {
		this.ownerClaimId = ownerClaimId;
	}


	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}


	



}