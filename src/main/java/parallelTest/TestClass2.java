package parallelTest;

import org.testng.annotations.Test;

public class TestClass2 {
	@Test
	public  void testMethod9() {
		System.out.println("Test Class3>testmethod9>"+Thread.currentThread().getId());
	}
	@Test
	public  void testMethod10() {
		System.out.println("Test Class3>testmethod10"+Thread.currentThread().getId());
	}
	@Test
	public  void testMethod11() {
		System.out.println("Test Class3>testmethod11"+Thread.currentThread().getId());
	}
	@Test
	public  void testMethod12() {
		System.out.println("Test Class3testmethod12"+Thread.currentThread().getId());
	}
	
}
