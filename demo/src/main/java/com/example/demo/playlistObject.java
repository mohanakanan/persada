package com.example.demo;

import java.util.ArrayList;

public class playlistObject {

    private long id;
    private pageObject singlePage;
    private collectObject singleCollection;
    
    private ArrayList<collectObject> collectionList = new ArrayList<collectObject>();
    private ArrayList<pageObject> pageList = new ArrayList<pageObject>();
    
	public playlistObject(long id) {
		super();
		this.id = id;
	}

	public playlistObject() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public pageObject getSinglePage() {
		return singlePage;
	}

	public void setSinglePage(pageObject singlePage) {
		this.singlePage = singlePage;
	}

	public collectObject getSingleCollection() {
		return singleCollection;
	}

	public void setSingleCollection(collectObject singleCollection) {
		this.singleCollection = singleCollection;
	}

	public ArrayList<collectObject> getCollectionList() {
		return collectionList;
	}

	public void setCollectionList(ArrayList<collectObject> collectionList) {
		this.collectionList = collectionList;
	}

	public ArrayList<pageObject> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<pageObject> pageList) {
		this.pageList = pageList;
	}
	
	
	
	
    

}
