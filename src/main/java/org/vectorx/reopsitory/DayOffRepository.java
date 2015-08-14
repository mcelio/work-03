package org.vectorx.reopsitory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vectorx.entity.DayOff;
import org.vectorx.ws.DaysOffServiceImpl;

@Named
public class DayOffRepository {

	// persistence unit
	@PersistenceUnit(name="jpa-persistence")
	private EntityManagerFactory entityManagerFactory;
	// Console logger
	static final Logger logger = LogManager.getLogger(DaysOffServiceImpl.class.getName());
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Gets next day off.
	 */
	public String getNextDayOff() throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			// the the current date.
			Date today = new Date();
			String sql = "SELECT d FROM DayOff d WHERE d.day > :today";
			Query query = em.createQuery(sql);
			query.setParameter("today", today, TemporalType.DATE);
			List<Object> list = query.getResultList();
			if (list != null && !list.isEmpty()) {
				DayOff dayoff = (DayOff) list.get(0);
				return dayoff.getDay() + " " + dayoff.getDescription();
			}
		} finally {
			em.close();
		}
		// return message with no results.
		return "Sem resultados";
	}

	/**
	 * Finds if the date parameter is a day off.
	 * 
	 * @param date
	 *            to be checked.
	 */
	public boolean isDayOff(String date) throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Date dayoff = dateFormat.parse(date);
			String sql = "SELECT d FROM DayOff d WHERE d.day = :date";
			Query query = em.createQuery(sql);
			query.setParameter("date", dayoff, TemporalType.DATE);
			List<Object> list = query.getResultList();
			if (list != null && !list.isEmpty()) {
				return true;
			}
		} finally {
			em.close();
		}
		return false;
	}

	/**
	 * Finds if the date parameter is a day off.
	 * 
	 * @param date
	 *            to be checked.
	 */
	public List<DayOff> getAllDayOff() throws Exception {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<DayOff> list = null;
		try {
			String sql = "SELECT d FROM DayOff d";
			Query query = em.createQuery(sql);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
}
