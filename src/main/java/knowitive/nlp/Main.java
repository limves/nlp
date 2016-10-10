package knowitive.nlp;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoNLLOutputter;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties props = new Properties();

		props.put("annotators", "tokenize, ssplit, pos, lemma"); 
		
		props.setProperty("tokenize.language", "es");
		props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/spanish/spanish-distsim.tagger");
		props.setProperty("ner.model", "edu/stanford/nlp/models/ner/spanish.ancora.distsim.s512.crf.ser.gz");
		props.setProperty("parse.model", "edu/stanford/nlp/models/lexparser/spanishPCFG.ser.gz");
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
		
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    
	    // create an empty Annotation just with the given text
	    Annotation document = new Annotation("Los contribuyentes que expidan y reciban CFDI, deberán almacenarlos en medios magnéticos, ópticos o de cualquier otra tecnología, en su formato electrónico XML.");
	    pipeline.annotate(document);
	    
	    String actual = new CoNLLOutputter().print(document); 
	    System.out.println("CoNLLOutputter :\n" + actual);

	}

}
