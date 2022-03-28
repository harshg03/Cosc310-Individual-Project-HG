import java.util.Properties;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
public class SentimentScorer {
//this class uses Sentiment analysis from Stanford CoreNLP to extract mood score of the input
	static Properties props;
	static StanfordCoreNLP pipeline;
	public static void main(String[] args) {
		init();
		System.out.println(getScore("This is ok"));
	}
	public static void init() {
	    Properties props = new Properties();
	    props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
	    pipeline = new StanfordCoreNLP(props);
	}
	public static int getScore(String s) {
		init();
		int score=0;
		if(s!=null &&s.length()>0) {
			
	        Annotation annotation = pipeline.process(s);
	        for (CoreMap sentence : annotation
	                .get(CoreAnnotations.SentencesAnnotation.class)) {
	            Tree tree = sentence
	                    .get(SentimentAnnotatedTree.class);
	            score = RNNCoreAnnotations.getPredictedClass(tree);
	        }
	    }
	    return score;
		}
		
	}

