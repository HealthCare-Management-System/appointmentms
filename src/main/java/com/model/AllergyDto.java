package com.model;

public class AllergyDto {

	private long allergyId;
	   
    private MasterAllergyDto masterId;
    
    private String isAllergyFatal;

	public long getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(long allergyId) {
		this.allergyId = allergyId;
	}

	public MasterAllergyDto getMaster_id() {
		return masterId;
	}

	public void setMaster_id(MasterAllergyDto master_id) {
		this.masterId = master_id;
	}

	public String getIsAllergyFatal() {
		return isAllergyFatal;
	}

	public void setIsAllergyFatal(String isAllergyFatal) {
		this.isAllergyFatal = isAllergyFatal;
	}
    
	
}
