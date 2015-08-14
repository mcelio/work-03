package org.vectorx.ws;

import java.util.List;

import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.vectorx.entity.DayOff;
import org.vectorx.reopsitory.DayOffRepository;

/**
 * Class responsible to implement the soap web service. 
 * 
 * @author Marcos
 *
 */
@WebService(endpointInterface = "org.vectorx.ws.DaysOffService", serviceName = "daysOffService")
public class DaysOffServiceImpl implements DaysOffService {

	// Console logger
	static final Logger logger = LogManager.getLogger(DaysOffServiceImpl.class.getName());
	
	@Autowired
	private DayOffRepository dayOffRepository; 
		
	/**
	 * Gets next day off.
	 */
	public String getNextDayOff() {		
		try {
			return dayOffRepository.getNextDayOff();
		} catch (Exception e) {
			logger.error("Error: ", e);
			return "Error: " + e.getMessage();
		}
	}

	/**
	 * Finds if the date parameter is a day off.
	 * @param date to be checked.
	 */
	public boolean isDayOff(String date) {
		try {
			return dayOffRepository.isDayOff(date);
		} catch (Exception e) {
			logger.error("Error: ", e);	
			return false;
		}
	}
	
	/**
	 * Finds all day off.
	 */
	public List<DayOff> getAllDayOff() throws Exception {
		return dayOffRepository.getAllDayOff();
	}

}
