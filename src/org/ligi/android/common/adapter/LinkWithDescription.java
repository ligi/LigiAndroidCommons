package org.ligi.android.common.adapter;

public class LinkWithDescription {
	private String url;
	private String description;
	public LinkWithDescription(String _url,String _description) {
		url=_url;
		description=_description;
	}
	
	public String getURL() {
		return url;
	}
	
	public String getDescription() {
		return description;
	}
}
