package org.vectorx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vectorx.entity.DayOff;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/applicationContext.xml",
		"file:src/main/webapp/WEB-INF/beans.xml" })
public class DayOffServiceTest {

	static final Logger logger = LogManager.getLogger(DayOffServiceTest.class.getName());

	// persistence unit
	private EntityManagerFactory emf;

	private EntityManager em;

	@Before
	public void initEmfAndEm() {
		emf = Persistence.createEntityManagerFactory("jpa-persistence");
		em = emf.createEntityManager();
		
	}

	@After
	public void cleanup() {
		em.close();
	}

	@Test
	public void testNextDayOff() {
		logger.error("Start test");
		boolean result = false;
		try {
			final String expectedDate = "2015-09-07";
			Date today = new Date();
			String sql = "SELECT d FROM DayOff d WHERE d.day > :today";
			Query query = em.createQuery(sql);
			query.setParameter("today", today, TemporalType.DATE);
			List<Object> list = query.getResultList();
			DayOff dayoff = null;
			if (list != null && !list.isEmpty()) {
				dayoff = (DayOff) list.get(0);
				final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				result = expectedDate.equals(dateFormat.format(dayoff.getDay()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(result);
		logger.error("Finish test");
	}

	@Test
	public void testIsDayOff() {
		logger.error("Start test");
		boolean result = false;
		try {
			final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			final String date = "2015-12-25 00:00:00";
			Date dayoff = dateFormat.parse(date);
			String sql = "SELECT d FROM DayOff d WHERE d.day = :date";
			Query query = em.createQuery(sql);
			query.setParameter("date", dayoff, TemporalType.DATE);
			List<Object> list = query.getResultList();
			if (list != null && !list.isEmpty()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(result);
		logger.error("Finish test");
	}

}
