import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BotTest extends Bot {
	private final Bot test_Bot = new Bot();

	@Test
	void test_getInput() {
		test_Bot.setInput("HOW IS YOUR DAY GOING.");
		String actual = test_Bot.getInput();
		String output = "how is your day going.";
		assertEquals(output, actual);
		fail("get_input method, did not pass test.");

		test_Bot.setInput("@$%^&*iujhg");
		actual = test_Bot.getInput();
		output = "@$%^&*iujhg";
		assertEquals(output, actual);
		fail("get_input method, did not pass test.");

		test_Bot.setInput("it is great.");
		actual = test_Bot.getInput();
		output = "it is great.";
		assertEquals(output, actual);
		fail("get_input method, did not pass test.");
	}

	//
	@Test
	void test_getResponse() {
		String output = "ERR"; // we expect this to be the output.
		test_Bot.setInput("throw_err");
		test_Bot.getResponse(); // this will change the currentOutput value , so we can later retrieve the
								// values.
		String actual = test_Bot.getInput();
		assertEquals(output, actual);
		fail("get_response() methods test failed.");

		test_Bot.setInput("depression");
		output = "I’m going to ask you a series of questions to access the possibility of you suffering from depression."; // we
																															// expect
																															// this
																															// to
																															// be
																															// the
																															// output.
		test_Bot.getResponse(); // this will change the currentOutput value , so we can later retrieve the
								// values.
		actual = test_Bot.getInput();
		assertEquals(output, actual);
		fail("get_response() methods test failed.");

		test_Bot.setInput("symptoms");
		output = "People with mild depression may experience the following: feelings of sadness, loss of appetite, reduced energy levels, sleeping problems, and difficulties with concentration. Mild depression is associated with a less intense feeling with those symptoms. It is highly recommended people with mild depression seek treatment. Do you have any more questions?"; // we
																																																																																														// expect
																																																																																														// this
																																																																																														// to
																																																																																														// be
																																																																																														// the
																																																																																														// output.
		test_Bot.getResponse(); // this will change the currentOutput value , so we can later retrieve the
								// values.
		actual = test_Bot.getInput();
		assertEquals(output, actual);
		fail("get_response() methods test failed.");

	}

	@Test
	void test_check_goodbye() {
		test_Bot.setInput("bye");
		boolean actual = test_Bot.check_goodbye();
		boolean output = true;
		assertEquals(output, actual);
		fail("Check goodbye method failed test.");
	}

	@Test
	void test_goodbye() {
		test_Bot.goodbye();
		String actual = test_Bot.getOutput();
		String output = "It was great talking to you! Goodbye!";
		System.out.println("output : " + actual.equals(output));
		assertEquals(output, actual);
		fail("goodbye method failed.");
	}

	@Test
	void test_greet() {
		// this is the only possible test case for this method . We will have to update
		// this method, if in the future we ever change the greeting.
		test_Bot.greet();
		String actual = test_Bot.getOutput();
		String output = "Hi! I'm Serenity! What's your name?";
		assertEquals(output, actual);

	}

	@Test
	void test_exists_in_input() {
		String key = "depresion"; // will try to match with depression
		test_Bot.setInput("depression");
		;
		boolean output = true;
		boolean actual = test_Bot.exists_in_input(key);
		assertEquals(output, actual);
	}

}
