package test_area;

public class OwnerDTO {

	
	 
	  private String owner_name;
	  private String phone;
	  public OwnerDTO(String owner_name, String phone) {
		super();
		this.owner_name = owner_name;
		this.phone = phone;
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
	
	
	
}
