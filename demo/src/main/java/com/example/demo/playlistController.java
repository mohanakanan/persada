package com.example.demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

@RestController
public class playlistController {

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
    
    //https://xcite-dev.spreeo.com/xcite/api/v1.0/admin/pages/{pageId}/
	
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
	    public boolean updatePlaylist(long playlistId) {
	    	
	    	boolean flag = false;
	    	playlistObject playlist = getPlaylist(playlistId);
	    	
	    	if (playlist != null) {
	    		//update playlist
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
				if (collectionId != 0) {
					url = new URL(" https://xcite-dev.spreeo.com/xcite/api/v1.0/collections/{" + collectionId + " }"); 
				} else {
					url = new URL("https://xcite-dev.spreeo.com/xcite/api/v1.0/collections/"); 
				}
				
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
	    public ArrayList<pageObject> removeAssetFromPlaylist() {
	    	
	    	ArrayList<playlistObject> playlist = new ArrayList<playlistObject>();
	    	playlist.get(0).getPageList()
	    	
	    	
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
	    public ArrayList<pageObject> removePageFromPlaylist() {
	    	
	    	ArrayList<playlistObject> playlist = new ArrayList<playlistObject>();
	    	playlist.get(0).getPageList()
	    	
	    	
	    }
	    
	    
//    @RequestMapping("/pages")
//    public ArrayList<pageObject> getPageList() {
//    	
//    	ArrayList<playlistObject> playlist = new ArrayList<playlistObject>();
//    	playlist.get(0).getPageList()
//    	
//    	
//    }
//    
//    @RequestMapping("/pages/{pageId}")
//    public pageObject getPage(@RequestParam(value="pageId", defaultValue="5acda19da168f92188f7b8c8") String pageId) {
//        return new pageObject(pageId);
//    }
//    
    
    

}
