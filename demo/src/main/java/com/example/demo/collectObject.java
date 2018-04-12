package com.example.demo;

import java.util.ArrayList;

public class collectObject {

    private long id;
    private String name;
    private String created;
    private String createdBy;
    private String modified;
    private String modifiedBy;
    
    private ArrayList<assetObject> assetList = new ArrayList<assetObject>();
    
    public collectObject() {
		super();
	}
    

	public collectObject(long id, String name, String created, String createdBy,
			String modified, String modifiedBy) {
		super();
		this.id = id;
		this.name = name;
		this.created = created;
		this.createdBy = createdBy;
		this.modified = modified;
		this.modifiedBy = modifiedBy;
	}

	

	public void setId(long id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}


	public void setCreated(String created) {
		this.created = created;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public void setModified(String modified) {
		this.modified = modified;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public long getId() {
		return id;
	}


	public String name() {
		return name;
	}

	public String getCreated() {
		return created;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public String getModified() {
		return modified;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public ArrayList<assetObject> getAssetList() {
		return assetList;
	}


	public void setAssetList(ArrayList<assetObject> assetList) {
		this.assetList = assetList;
	}


	public String getName() {
		return name;
	}
    
    
    /*
     * 
     * id": "5a96371ec415cf10e4b31b6a",
                "fileName": "museum-poster-v2-01.jpg",
                "uuid": "a3f3d1a7-7b49-459c-93c1-f45ab1e706b3",
                "collection": "5a96360fc415cf10e4b31b69",
                "created": "2018-02-28T04:59:10.080+0000",
                "createdBy": "5a550c27f1ded7c2574c0dcb",
                "modified": "2018-02-28T04:59:10.080+0000",
                "modifiedBy": "5a550c27f1ded7c2574c0dcb",
                "url": "https://xcite-dev-infra.spreeo.com/uploads/a3f3d1a7-7b49-459c-93c1-f45ab1e706b3/museum-poster-v2-01.jpg"
     
     */
}
