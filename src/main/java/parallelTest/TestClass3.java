package parallelTest;

import org.testng.annotations.Test;

public class TestClass3 {
	@Test
	public  void testMethod5() {
		System.out.println("Test Class2>testmethod5>"+Thread.currentThread().getId());
	}
	@Test
	public  void testMethod6() {
		System.out.println("Test Class2>testmethod6>"+Thread.currentThread().getId());
	}
	@Test
	public  void testMethod7() {
		System.out.println("Test Class2>testmethod7>"+Thread.currentThread().getId());
	}
	@Test
	public  void testMethod8() {
		System.out.println("Test Class1>testmethod8>"+Thread.currentThread().getId());
	}
	
}
