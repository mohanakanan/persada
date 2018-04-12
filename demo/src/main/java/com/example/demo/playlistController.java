package com.example.demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

@RestController
public class playlistController {


	 private String inline;

	@RequestMapping("/createplaylist")
	    public playlistObject createPlaylist(long pageId, long collectionId) {
	    	
		 	//get page & populate page object
			pageObject singlePage = getPage(pageId);
			
		 
		 	//get collection with assets
			collectObject singleCollection = getCollection(collectionId);
		
			//assetObject singleAsset = getAsset(singleCollection.getId());
		 	
		 	playlistObject playlist = new playlistObject();
		 	playlist.setSinglePage(singlePage);
		 	playlist.setSingleCollection(singleCollection);
	    	
	    	return playlist;
	    }
	    
	    @RequestMapping("/getplaylist")
	    public playlistObject getPlaylist(long playlistId) {
	    	
	    	return new playlistObject(playlistId);
	    }
	    
	    @RequestMapping("/updateplaylist")
	    public boolean updatePlaylist(long playlistId, collectObject singleCollection, ArrayList<assetObject> multipleAsset) {
	    	
	    	boolean flag = false;
	    	playlistObject playlist = getPlaylist(playlistId);
	    	
	    	if (playlist != null) {
	    		
	    		//update playlist
	    		collectObject updatedCollection = addAssetToCollection(singleCollection.getId(), multipleAsset);
	    		 
	    		playlist.setSingleCollection(updatedCollection);
	    		flag = true;
	    	} 
	    	
	    	return flag;
	    	
	    }
	    
	    @RequestMapping("/removeplaylist")
	    public boolean removePlaylist(long playlistId) {
	    	
	    	boolean flag = false;
	    			
	    	playlistObject playlist = getPlaylist(playlistId);
	    	
	    	if (playlist != null) {
	    		//delete playlist
	    		flag = true;
	    	} 
	    	
	    	return flag;
	    }
	    
	    @RequestMapping("/getcollection")
	    public collectObject getCollection(long collectionId) {
	    	
	    	collectObject singleCollect = new collectObject();
			ArrayList<JSONObject> json=new ArrayList<JSONObject>();
			
			URL url;
			
			 try {
				url = new URL(" https://xcite-dev.spreeo.com/xcite/api/v1.0/collections/{" + collectionId + " }"); 

				
				Scanner sc = new Scanner(url.openStream());
			 	HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
			 	conn.setRequestMethod("GET");
			 	conn.connect(); 

			 	while(sc.hasNext())

			 	{

			 		 JSONObject obj= (JSONObject) new JSONParser().parse(sc.nextLine());
			         json.add(obj);

			 	}
			 	
			 	sc.close();
			 	
			 	 for(JSONObject obj : json){
			 		singleCollect.setId((long)obj.get("id"));
			 		singleCollect.setName((String)obj.get("name"));
			 		singleCollect.setCreated((String)obj.get("created"));
			 		singleCollect.setCreatedBy((String)obj.get("created"));
			 		singleCollect.setModified((String)obj.get("modified"));
			 		singleCollect.setModifiedBy((String)obj.get("modifiedBy"));
			     }
			 	
			 	} catch (Exception e) {
			        e.printStackTrace();
			    } 
	    	
	    	
			 return singleCollect;
	    	
	    	
	    }
	    
	    @RequestMapping("/addassets")
	    public collectObject addAssetToCollection(long collectionId, ArrayList<assetObject> multipleAsset) {

	    	collectObject collectObj = getCollection(collectionId);
	    	collectObj.setAssetList(multipleAsset);

	    	return collectObj;
	    	
	    	
	    }
	    
	    
	    @RequestMapping("/getassets")
	    public ArrayList<assetObject> getAssetFromCollection(long collectionId) {

	    	ArrayList<assetObject>  multipleAssets = new ArrayList<assetObject>();
	    	assetObject singleAsset = new assetObject();
	    	
			ArrayList<JSONObject> json=new ArrayList<JSONObject>();
			
			 try {
				URL url = new URL("https://xcite-dev.spreeo.com/xcite/api/v1.0/collections/{" + collectionId + "}/assets "); 
				Scanner sc = new Scanner(url.openStream());
			 	HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
			 	conn.setRequestMethod("GET");
			 	conn.connect(); 

			 	while(sc.hasNext())

			 	{

			 		 JSONObject obj= (JSONObject) new JSONParser().parse(sc.nextLine());
			         json.add(obj);

			 	}
			 	
			 	sc.close();
			 	
			 	 for(JSONObject obj : json){
			 		singleAsset.setId((long)obj.get("id"));
			 		singleAsset.setFileName((String)obj.get("fileName"));
			 		singleAsset.setUuid((long)obj.get("uuid"));
			 		singleAsset.setCollection((long)obj.get("collection"));
			 		singleAsset.setCreated((String)obj.get("created"));
			 		singleAsset.setCreatedBy((String)obj.get("createdBy"));
			 		singleAsset.setModified((String)obj.get("modified"));
			 		singleAsset.setModifiedBy((String)obj.get("modifiedBy"));
			 		singleAsset.setUrl((String)obj.get("url"));
			     }
			 	
			 	multipleAssets.add(singleAsset);
			 	
			 	} catch (Exception e) {
			        e.printStackTrace();
			    } 
	    	
	    	
			 return multipleAssets;
	    	
	    	
	    }
	    
	    @RequestMapping("/removeasset")
	    public boolean removeAssetFromPlaylist(long assetId, long collectionId, long playlistId) {
	    	boolean flag = false;
	    	playlistObject playObj = getPlaylist(playlistId);
	    	
	    	ArrayList<assetObject> assetList = getAssetFromCollection(playObj.getSingleCollection().getId());
	    	
	    			for (assetObject temp : assetList) {
	    				if(temp.getId() == assetId) {
	    					flag = assetList.remove(temp);
	    				}
	    			}

	    			return flag;
	    }
	    
	    @RequestMapping("/getpage")
	    public pageObject getPage(long pageId) {
	    	
	    	pageObject singlePage = new pageObject();
			ArrayList<JSONObject> json=new ArrayList<JSONObject>();
			 try {
				URL url = new URL("https://xcite-dev.spreeo.com/xcite/api/v1.0/admin/pages/"); 
				Scanner sc = new Scanner(url.openStream());
			 	HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
			 	conn.setRequestMethod("GET");
			 	conn.connect(); 

			 	while(sc.hasNext())

			 	{

			 		 JSONObject obj= (JSONObject) new JSONParser().parse(sc.nextLine());
			         json.add(obj);

			 	}
			 	
			 	sc.close();
			 	
			 	 for(JSONObject obj : json){
			 		singlePage.setCollection((String)obj.get("collection"));
			     }
			 	
			 	} catch (Exception e) {
			        e.printStackTrace();
			    } 
	    	
	    	
			 return singlePage;
	    }
	    
	    @RequestMapping("/removepage")
	    public boolean removePageFromPlaylist(long pageId, long playlistId) {
	    	
	    	boolean flag = false;
	    	playlistObject playObj = getPlaylist(playlistId);

	    	ArrayList<pageObject> pageList = getPagesFromPlaylist(pageId, playObj);
	    	
	    			for (pageObject temp : pageList) {
	    				if(temp.getId() == pageId) {
	    					flag = pageList.remove(temp);
	    				}
	    			}

	    			return flag;
	    	
	    	
	    }
	    
	    
	    @RequestMapping("/getpages")
	    public ArrayList<pageObject> getPagesFromPlaylist(long pageId, playlistObject playObj ) {
	    		    	
	    	ArrayList<pageObject>  multiplePages =  playObj.getPageList();
	    	
	    	return multiplePages;
			    	
	    	
	    }
    

}
