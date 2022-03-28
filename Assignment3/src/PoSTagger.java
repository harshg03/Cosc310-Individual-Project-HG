
import java.util.StringTokenizer;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class PoSTagger {
	//this class uses Parts of Speech tagging from CoreNLP Stanford toolkit to retreive required part of speech
	public static void main(String[] args) {
		System.out.println(
				getProperNoun("my name is ayesha"));
	}
	public static String getProperNoun(String sample) {
		MaxentTagger tagger=new MaxentTagger("lib/english-left3words-distsim.tagger");
		//String tagged=tagger.tagString(sample);
		StringTokenizer st=new StringTokenizer(sample);
		while(st.hasMoreTokens()) {
			String t=st.nextToken();
			if(tagger.tagString(t).equals(t+"_NNP ")) {
				return t.substring(0,1).toUpperCase()+t.substring(1);
			}
		}
		return "";
		
	}
	

}
