import java.util.Properties;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Optimizer {
	// uses Lemmatization from CoreNLP Stanford toolkit to create an optimized search string by reducing to lemma and removes punctuation
	public static void main(String[] args) {
		String text="great symptoms job";
		System.out.println(getOptimized(text));
	}
	
	public static String getOptimized(String s) {
		if(s=="")
			return "";
		String result="";
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
	    // build pipeline
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    // create a document object
	    CoreDocument document = pipeline.processToCoreDocument(s);
	    for (CoreLabel tok : document.tokens()) {
	    	result=result+tok.lemma()+" ";
	        //System.out.println(tok.word()+ tok.lemma());
	      }
		return result;
		
	}
	public static String removePunc(String s) {
		
		String result=s.replaceAll("\\p{Punct}", "");
		return result;
		
	}

}
