package com.example.demo;

import java.util.Date;
import java.util.List;

public class pageObject {

    private long id;
    private String title;
    private String excerpt;
    private String slug;
    private String lockPattern;
    private String contentFormat;
    private String styles;
    private String content;
    private String categories;
    private String collection;
    private String screenshot;
    private Date pageDate;
    
    private String created;
    private String createdBy;
    private String modified;
    private String modifiedBy;
    
    
    public pageObject() {
		super();
	}
    
	public pageObject(long id, String title, String excerpt, String slug, String lockPattern, String contentFormat,
			String styles, String content, String categories, String collection, String screenshot, Date pageDate,
			String created, String createdBy, String modified, String modifiedBy) {
		super();
		this.id = id;
		this.title = title;
		this.excerpt = excerpt;
		this.slug = slug;
		this.lockPattern = lockPattern;
		this.contentFormat = contentFormat;
		this.styles = styles;
		this.content = content;
		this.categories = categories;
		this.collection = collection;
		this.screenshot = screenshot;
		this.pageDate = pageDate;
		this.created = created;
		this.createdBy = createdBy;
		this.modified = modified;
		this.modifiedBy = modifiedBy;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setLockPattern(String lockPattern) {
		this.lockPattern = lockPattern;
	}

	public void setContentFormat(String contentFormat) {
		this.contentFormat = contentFormat;
	}

	public void setStyles(String styles) {
		this.styles = styles;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public void setPageDate(Date pageDate) {
		this.pageDate = pageDate;
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

	public String getTitle() {
		return title;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public String getSlug() {
		return slug;
	}

	public String getLockPattern() {
		return lockPattern;
	}

	public String getContentFormat() {
		return contentFormat;
	}

	public String getStyles() {
		return styles;
	}

	public String getContent() {
		return content;
	}

	public String getCategories() {
		return categories;
	}

	public String getCollection() {
		return collection;
	}

	public String getScreenshot() {
		return screenshot;
	}

	public Date getPageDate() {
		return pageDate;
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
    
//	 public String toString() { 
//         return pageObject(this.id, this.title, this.excerpt, this.slug, 
// 		this.lockPattern = lockPattern;
// 		this.contentFormat = contentFormat;
// 		this.styles = styles;
// 		this.content = content;
// 		this.categories = categories;
// 		this.collection = collection;
// 		this.screenshot = screenshot;
// 		this.pageDate = pageDate;
// 		this.created = created;
// 		this.createdBy = createdBy;
// 		this.modified = modified;
// 		this.modifiedBy = modifiedBy);
//      } 
    
}


/*

 "id": "5acda19da168f92188f7b8c8",
            "title": "Test17",
            "excerpt": "Test17",
            "slug": "test17",
            "lockPattern": "",
            "contentFormat": "IMAGE",
            "styles": "",
            "content": "{\"RAW\":{\"html\":\"<!-- enter your html -->\"},\"IMAGE\":{\"mediaAssetId\":\"5acd9806a168f92188f7b8c2\"}}",
            "categories": [
                "5a730f3008823737807626a7"
            ],
            "collection": null,
            "screenshot": null,
            "date": "2018-04-10",
            "created": "2018-04-11T05:48:13.002Z",
            "createdBy": "5a550c27f1ded7c2574c0dcb",
            "modified": "2018-04-11T05:48:13.002Z",
            "modifiedBy": "5a550c27f1ded7c2574c0dcb"

*/