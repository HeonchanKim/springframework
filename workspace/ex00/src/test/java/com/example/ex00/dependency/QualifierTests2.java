package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Computer;
import com.example.ex00.dependency.qualifier.Restaurant;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QualifierTests2 {

	@Autowired
	@Qualifier("outback")
	private Restaurant outback;
	
	@Autowired
	@Qualifier("vips")
	private Restaurant vips;
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testQualifier() {
		log.info("------------------");
		log.info("outback" + outback);
		log.info("steak price: " + outback.steak);
		log.info("outback hasSalad: " + outback.hasSalad());
		log.info("------------------");
		
		log.info("------------------");
		log.info("vips" + vips);
		log.info("steak price: " + vips.steak);
		log.info("vips hasSalad: " + vips.hasSalad());
		log.info("------------------");
		
		log.info("------------------");
		log.info("restaurant" + restaurant);
		log.info("steak price: " + restaurant.steak);
		log.info("hasSalad: " + restaurant.hasSalad());
		log.info("------------------");
		
	}
	
}
