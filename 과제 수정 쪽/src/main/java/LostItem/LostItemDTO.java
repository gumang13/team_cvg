package LostItem;


import java.sql.Date;

public class LostItemDTO {
	
	private String item_name;
	private String feature;
	private String category;
	private String status;
	private String itemStorage;
	private Date lost_date;
	
	
	
	public LostItemDTO() {
	}
	
	public LostItemDTO(String item_name, String feature, String category, String status, String itemStorage,
			Date lost_date) {
		super();
		this.item_name = item_name;
		this.feature = feature;
		this.category = category;
		this.status = status;
		this.itemStorage = itemStorage;
		this.lost_date = lost_date;
	}
	
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItemStorage() {
		return itemStorage;
	}
	public void setItemStorage(String itemStorage) {
		this.itemStorage = itemStorage;
	}
	public Date getLost_date() {
		return lost_date;
	}
	public void setLost_date(Date lost_date) {
		this.lost_date = lost_date;
	}
	
	

}
