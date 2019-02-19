package com.qa.helpers;

public class Headers {

	 private String Authorization;

	    private String ContentType;

	    public String getAuthorization ()
	    {
	        return Authorization;
	    }

	    public void setAuthorization (String Authorization)
	    {
	        this.Authorization = Authorization;
	    }

	    public String getContentType ()
	    {
	        return ContentType;
	    }

	    public void setContentType (String ContentType)
	    {
	        this.ContentType = ContentType;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [Authorization = "+Authorization+", Content-Type = "+ContentType+"]";
	    }
}
