package org.vectorx.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface DaysOffService {

	@WebMethod
    public boolean isDayOff(String date);
	
	@WebMethod
    public String getNextDayOff();
	
}
