import com.guan.BreakWords;
import com.guan.common.CreateSolutionFactory;
import com.guan.common.WordsDict;
import com.guan.type.DictionaryType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Tiangang.guan
 * this is stage 1
 * provide  customized dictionary and add additional input  to test
 */
public class WordBreakTestTwo {
    /**
     * import the interface to break string
     */
    public final static String SECOND_SENTENCE = "ilikeapple";

    /**
     * import the interface to break string,create by simple factory
     */
    private BreakWords breakWords = CreateSolutionFactory.getSolution(DictionaryType.SECOND);

    /**
     * get the dictionary instance
     */
    private WordsDict wordsDict = WordsDict.getInstance();

    /**
     * test the second dictionary and get the result
     */
    @Test
    public void testSecondSentence() {
        List<String> list = breakWords.breakTargetWords(SECOND_SENTENCE, wordsDict.getWordDict(DictionaryType.SECOND));
        Assert.assertTrue(list.size() == 1);
        list.forEach(System.out::println);
    }

    /**
     * test the no words in the dictionary and can see the result is empty
     */
    @Test
    public void testSecondSentenceTwo() {
        String two = SECOND_SENTENCE + "andsam";
        List<String> list = breakWords.breakTargetWords(two, wordsDict.getWordDict(DictionaryType.SECOND));
        Assert.assertTrue(list.size() == 1);
        list.forEach(System.out::println);
    }

}
