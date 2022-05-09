package com.simplilearn.webapptest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StandardAnnotationTest {
	
	@BeforeClass
	void beforeClass() {
		System.out.println("Before Class is running ");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("After class is running");
	}
	@BeforeMethod
	void testOne() {
		System.out.println("Before Test method is running ");
	}
	
	@AfterMethod
	void testTwo() {
		System.out.println("After Test method is running");
	}
	@Test
	void testThree() {
		System.out.println("Test three is running");
	}
	@Test
	void testFour() {
		System.out.println("Test four is running");
	}
	@Test
	void testFive() {
		System.out.println("Test five is running");
	}

}
