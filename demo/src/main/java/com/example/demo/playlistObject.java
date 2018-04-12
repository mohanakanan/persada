package com.example.demo;

import java.util.ArrayList;

public class playlistObject {

    private long id;
    private assetObject singleAsset;
    private pageObject singlePage;
    private collectObject singleCollection;
    
    private ArrayList<assetObject> assetList = new ArrayList<assetObject>();
    private ArrayList<pageObject> pageList = new ArrayList<pageObject>();
    
	public playlistObject(long id) {
		super();
		this.id = id;
	}

	public playlistObject() {
		super();
	}

	
	public assetObject getSingleAsset() {
		return singleAsset;
	}


	public void setSingleAsset(assetObject singleAsset) {
		this.singleAsset = singleAsset;
	}


	public pageObject getSinglePage() {
		return singlePage;
	}


	public void setSinglePage(pageObject singlePage) {
		this.singlePage = singlePage;
	}


	public long getId() {
		return id;
	}

	public ArrayList<assetObject> getAssetList() {
		return assetList;
	}

	public ArrayList<pageObject> getPageList() {
		return pageList;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setAssetList(ArrayList<assetObject> assetList) {
		this.assetList = assetList;
	}


	public void setPageList(ArrayList<pageObject> pageList) {
		this.pageList = pageList;
	}


	public collectObject getSingleCollection() {
		return singleCollection;
	}


	public void setSingleCollection(collectObject singleCollection) {
		this.singleCollection = singleCollection;
	}
    
    

}
