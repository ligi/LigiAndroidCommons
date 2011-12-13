package org.ligi.android.common.adapter;

public class LinkWithDescriptionAndTitle extends LinkWithDescription {
	
	private String title;
	
	public LinkWithDescriptionAndTitle(String url,String description,String title) {
		super(url,description);
		this.title=title;
	}

	public String getTitle() {
		return title;
	}
	
}
