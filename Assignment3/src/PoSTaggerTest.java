import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PoSTaggerTest {

	@Test
	void test_getProperNoun() {
		String s = "my name is Serenity";
		String actual = PoSTagger.getProperNoun(s);
		String output = "Serenity";
		assertEquals(output, actual);
		
		
		s = "my name is Ayesha";
		actual = Optimizer.getOptimized(s);
		output = "Ayesha";
		assertEquals(output, actual);
		
		s = "";
		actual = Optimizer.getOptimized(s);
		output = "";
		assertEquals(output, actual);
	
	}

}
