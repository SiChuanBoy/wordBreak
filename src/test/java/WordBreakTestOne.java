import com.guan.BreakWords;
import com.guan.common.CreateSolutionFactory;
import com.guan.common.WordsDict;
import com.guan.type.DictionaryType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * test the string to be a Sentence
 * this is stage 1
 * @author Tiangang.Guan
 */
public class WordBreakTestOne {

    //input the String to test
    public final static String FIRSTSENTENCE = "ilikesamsungmobile";
    public final static String FIRSTSENTENCE_TWO = "ilikeicecreamandmango";

    /**
     * import the interface to break string
     * can DictionaryType to crate the other function
     */
    private BreakWords breakWords = CreateSolutionFactory.getSolution(DictionaryType.FIRST);

    /**
     * get the dictionary instance
     */
    private WordsDict wordsDict = WordsDict.getInstance();

    /**
     * test the first dictionary and get the result
     */
    @Test
    public void testFirstSentence(){
        List<String> list = breakWords.breakTargetWords(FIRSTSENTENCE, wordsDict.getWordDict(DictionaryType.FIRST));
        Assert.assertTrue(list.size() == 2);
        list.forEach(System.out::println);
    }
    /**
     * test the first dictionary and get the result
     */
    @Test
    public void testFirstSentenceTwo(){
        List<String> list = breakWords.breakTargetWords(FIRSTSENTENCE_TWO, wordsDict.getWordDict(DictionaryType.FIRST));
        Assert.assertTrue(list.size() == 1);
        list.forEach(System.out::println);
    }


    /* ------------under is other test that myself-------------- */
    /**
     * If  intercept the string to test whether it can be get
     */
    @Test
    public void testFirstSentenceSub(){
        List<String> list = breakWords.breakTargetWords(FIRSTSENTENCE.substring(1), wordsDict.getWordDict(DictionaryType.FIRST));
        Assert.assertTrue(list.size() == 2);
        list.forEach(System.out::println);
    }

    /**
     * if the string no word in the dictionary, the result was empty
     */
    @Test
    public void testFirstSentenceNotInDict(){
        List<String> list = breakWords.breakTargetWords("canhelpsomeonedrive", wordsDict.getWordDict(DictionaryType.FIRST));
        Assert.assertTrue(list.size() == 0);
        list.forEach(System.out::println);
    }

}
