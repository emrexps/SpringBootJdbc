package com.jdbcsample.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbcsample.demo.dao.StudentDao;
import com.jdbcsample.demo.entity.Student;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentDao studentDao;
	
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	logger.info("All users -> {}", studentDao.findAll());
		
		logger.info("User id 101 -> {}", studentDao.findById(101));
		
		logger.info("Deleting 102 -> No of Rows Deleted - {}", studentDao.deleteById(102));
		
		logger.info("Inserting 103 -> {}", 
				studentDao.insert(new Student(103, "James", "Trump")));
		
		logger.info("Update 103 -> {}", 
				studentDao.update(new Student(103, "Donald", "Trump")));
		
	}
		
	}

