package team_cvg_lostAndFound;

import java.util.Scanner;

public class OwnerClaimDTO {
	
	private long lost_item_id;
	private long owner_claim_id;
	private String owner_name;
	private String phone;
	private boolean matched;
	
	public OwnerClaimDTO() {}

    public OwnerClaimDTO(int owner_claim_id, int lost_item_id, String owner_name,
                         String phone, boolean matched) {
        this.owner_claim_id = owner_claim_id;
        this.lost_item_id = lost_item_id;
        this.owner_name = owner_name;
        this.phone = phone;
        this.matched = matched;
    }
    
	public long getLost_item_id() {
		return lost_item_id;
	}
	public void setLost_item_id(long lost_item_id) {
		this.lost_item_id = lost_item_id;
	}
	public long getOwner_claim_id() {
		return owner_claim_id;
	}
	public void setOwner_claim_id(long owner_claim_id) {
		this.owner_claim_id = owner_claim_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	
	
}
