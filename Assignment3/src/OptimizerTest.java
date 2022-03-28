import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OptimizerTest {
	@Test
	void test_getoptimized(){
		String s = "happy going leaving";
		String actual = Optimizer.getOptimized(s);
		String output = "happy go leave";
		assertEquals(output, actual);
		fail("testcase 1 failed");
		
		s = "great job";
		actual = Optimizer.getOptimized(s);
		output = "great job";
		assertEquals(output, actual);
		fail("testcase 2 failed");
	}

	
	@Test
	void test_removePunc() {
		String s = ".?,;!";
		String actual = Optimizer.removePunc(s);
		String output = "";
		assertEquals(output, actual);
		fail("removePunc method, did not pass test.");
	}

}
