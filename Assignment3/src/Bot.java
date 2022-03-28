import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bot {
	// responsible for the agent's functionality, sets current input and sets
	// current output based on input
	String name;
	private String currentInput;
	private String currentOutput;
	float mood_score = 0;
	float mood_count = 0;
	float exchange_count = 0;
	boolean keep_going = true;
	HashMap<String, String> responses = new HashMap<String, String>();
	// ArrayList<String> endings=new ArrayList<String>();
	String[] bye_words = { "go", "leave", "bye", "end" };
	String[] apologies = { "I don't understand. Could you try phrasing it a different way?",
			"I'm not sure what you mean by that.", "Hmm. I'm not sure I can help with that. Anything else?",
			"I'm sorry, I'm not smart enough to understand what you meant. Try saying something else?",
			"I think I don't understand what you meant. Could you clarify?" };;
	String[] talk_to_me = { "The silent treatment I see. Well I'm here if you need me.",
			"I can't help you if you don't talk to me!",
			"You can tell me anything! Type in the text box when you feel ready" };

	Bot() {
		name = "User";
		load();
	}
	public void updateMoodScore() {
		mood_score = mood_score + SentimentScorer.getScore(currentInput);
		mood_count++;
	}

	public void optimizeInput() {
		currentInput= Optimizer.removePunc(currentInput);
		currentInput = Optimizer.getOptimized(currentInput);

	}

	public String getInput() {
		// TODO Auto-generated method stub
		return currentInput;
	}

	public void load()  {
		
		try {
			responses=ReadFromFile.txtToMap("responses.txt", "]");
		} catch (IOException e) {
			;
		}
		
	}

	public void setInput(String input) {

		currentInput = input.toLowerCase();
		System.out.println(input);

	}

	public void setOutput(String s) {

		//System.out.println(s);
		currentOutput = s;

	}

	public String getOutput() {
		return currentOutput;
	}

	public void getResponse() {
		if(getInput()=="") {
			setOutput(talk_to_me[(int)(talk_to_me.length*Math.random())]);
		}
		else {
		boolean b = false;
		for (String key : responses.keySet()) {
			if (exists_in_input(key)) {
				setOutput(responses.get(key));
				b = true;
				break;
			}
		}
		if (!b) {
			apologize();
		}
		}

	}

	public boolean exists_in_input(String key) {
		StringTokenizer st = new StringTokenizer(currentInput);
		while (st.hasMoreTokens()) {
			String t = st.nextToken();
			if (LevenshteinDistance.getDistance(t, key) > 0.75) {
				return true;
			}
		}
		return false;
	}

	public void apologize() {

		String resp = apologies[(int) (apologies.length * Math.random())];
		setOutput(resp);

	}

	public void greet() {
		setOutput("Hi! I'm Serenity! What's your name?");
		return;

	}

	public void inform() {
		String information="";
		switch ((int) (mood_score / exchange_count)) {
		
			case 0:
				information="For people in troublesome situations like yourself reach out to one or more of the following resources: local psychiatrist, local doctor, someone you trust.For immediate support please call 310-6789 for the BC Mental Health Support Line or 811 to talk with a registered nurse or pharmacist about your symptoms, if you are in distress please contact the suicide hotline at 1-800-784-2433.";
				break;
			case 1:
				information="Getting over your obstacles is important to us to get support contact the following: local psychiatrist, local doctor, someone you trust. For immediate support please call 310-6789 for the BC Mental Health Support Line or 811 to talk with a registered nurse or pharmacist about your symptoms.";
				break;
			case 2:
				information="The following resources will provide support for you: local psychiatrist, local doctor, someone you trust, and for immediate support please call 310-6789 for the BC Mental Health Support Line";
				break;
			case 3:
				information="Good to see you well keep in contact with these resources: local psychiatrist, local doctor, someone you trust, for immediate support please call 310-6789 for the BC Mental Health Support Line.";
			case 4:
				information="it is so encouraging to see you like this pay a visit to our suggested resources: local psychiatrist, local doctor, someone you trust,for immediate support please call 310-6789 for the BC Mental Health Support Line.";
				break;

		}
		setOutput(information);

	}

	public void suggestHelp() {
		switch ((int) (mood_score / exchange_count)) {
			case 0: {
				// tell user to get urgent help
				String suggestion=name+ " the tone in your responses is very concerning. I suggest you seek treatment from a local psychiatrist or therapist as soon as possible.";
				setOutput(suggestion);

				;
			}
				break;
			case 1: {
				// tell user you are concerned and they should get help soon
				String suggestion=name+ " the tone in your response is somewhat concerning. I suggest you seek treatment from a local psychiatrist or therapist soon.";
				setOutput(suggestion);
			}
		}
	}

	public void affirm() {
		String affirmation=name;
		switch ((int) (mood_score / exchange_count)) {
			case 0:
				affirmation=affirmation+" you are not alone. People go through  difficulties just like the ones you are facing right now these people handle their difficulties with the help of others you can do it too.";
			case 1:
				affirmation=affirmation+" I know you are having a hard time with this, but I believe you can get through it.";
				break;
			case 2:
				affirmation=affirmation+" things seem to ge going alright for you, I'm glad!";
				break;
			case 3:
				affirmation=affirmation+" it makes me so happy to see you like this! Please continue to be happy to avoid setbacks.";
			case 4:
				affirmation=affirmation+"  it is so inspiring to see you like this! You're a rockstar!";
				break;

		}
		setOutput(affirmation);

	}

	public boolean check_goodbye() {
		for (String word : bye_words) {
			if (exists_in_input(word))
				return true;
		}
		return false;

	}

	public void goodbye() {
		keep_going = false;
		setOutput("It was great talking to you! Goodbye!");

	}

}
