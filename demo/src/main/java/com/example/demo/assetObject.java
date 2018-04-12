package com.example.demo;

public class assetObject {

    private long id;
    private String fileName;
    private long uuid;
    private long collection;
    private String created;
    private String createdBy;
    private String modified;
    private String modifiedBy;
    private String url;
    
    public assetObject() {
		super();
	}
    

	public assetObject(long id, String fileName, long uuid, long collection, String created, String createdBy,
			String modified, String modifiedBy, String url) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.uuid = uuid;
		this.collection = collection;
		this.created = created;
		this.createdBy = createdBy;
		this.modified = modified;
		this.modifiedBy = modifiedBy;
		this.url = url;
	}

	

	public void setId(long id) {
		this.id = id;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public void setUuid(long uuid) {
		this.uuid = uuid;
	}



	public void setCollection(long collection) {
		this.collection = collection;
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



	public void setUrl(String url) {
		this.url = url;
	}



	public long getId() {
		return id;
	}


	public String getFileName() {
		return fileName;
	}


	public long getUuid() {
		return uuid;
	}


	public long getCollection() {
		return collection;
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


	public String getUrl() {
		return url;
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
