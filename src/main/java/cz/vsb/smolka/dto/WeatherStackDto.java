package cz.vsb.smolka.dto;

public class WeatherStackDto {

	    public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
		public Request request;
	    public Location location;
	    public Current current;
	}

