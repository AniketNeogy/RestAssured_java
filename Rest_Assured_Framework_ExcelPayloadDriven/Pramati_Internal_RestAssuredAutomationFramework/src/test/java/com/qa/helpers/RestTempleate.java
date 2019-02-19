package com.qa.helpers;

public class RestTempleate {

    private Headers headers;

    private String body;

    private String method;

    private Parameters parameters;

    private String uriPath;

    public Headers getHeaders ()
    {
        return headers;
    }

    public void setHeaders (Headers headers)
    {
        this.headers = headers;
    }

    public String getBody ()
    {
        return body;
    }

    public void setBody (String body)
    {
        this.body = body;
    }

    public String getMethod ()
    {
        return method;
    }

    public void setMethod (String method)
    {
        this.method = method;
    }

    public Parameters getParameters ()
    {
        return parameters;
    }

    public void setParameters (Parameters parameters)
    {
        this.parameters = parameters;
    }

    public String getUriPath ()
    {
        return uriPath;
    }

    public void setUriPath (String uriPath)
    {
        this.uriPath = uriPath;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [headers = "+headers+", body = "+body+", method = "+method+", parameters = "+parameters+", uriPath = "+uriPath+"]";
    }
}
			
			