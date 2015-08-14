package org.vectorx;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vectorx.entity.DayOff;
import org.vectorx.reopsitory.DayOffRepository;
 
@ManagedBean
@SessionScoped
public class DayOffBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DayOffRepository dayOffRepository;
	
	// Console logger
	static final Logger logger = LogManager.getLogger(DayOffBean.class.getName());
	
	private List<DayOff> list;
 	
	private String name;
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DayOff> getList() {
		try{
			return dayOffRepository.getAllDayOff();	
		}catch(Exception e){
			logger.error("Error: ", e);	
			return null;
		}
		
	}
	public void setList(List<DayOff> list) {
		this.list = list;
	}
	
}
