import com.guan.BreakWords;
import com.guan.common.CreateSolutionFactory;
import com.guan.common.WordsDict;
import com.guan.type.DictionaryType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tiangang.guan
 * provide  customized dictionary and add additional input  to test and find all
 * this is stage 3
 */
public class WordBreakThree {
    /**
     * import the interface to break string
     */
    public final static String THIRD_SENTENCE = "likeicecreammango";

    /**
     * import the interface to break string,create by simple factory
     */
    private BreakWords breakWords = CreateSolutionFactory.getSolution(DictionaryType.THIRD);

    /**
     * get the dictionary instance
     */
    private WordsDict wordsDict = WordsDict.getInstance();

    /**
     * if add extra word to dictionary and give string, the last result
     */
    @Test
    public void testFirstSentenceNotRight() {
        //this is extra dictionary
        String[] arr = {"and", "apple"};
        wordsDict.addWord(Arrays.asList(arr), DictionaryType.THIRD);
        //when add additional string
        String tem = THIRD_SENTENCE + "andapple";
        List<String> list = breakWords.breakTargetWords(tem, wordsDict.getWordDict(DictionaryType.THIRD));
        //the result is 2,as the man go and mango could appear together
        Assert.assertTrue(list.size() == 2);
        list.forEach(System.out::println);
    }

    /**
     * if add a word into the  dictionary, it has a result
     */
    @Test
    public void testSecondSentenceNotInDict() {
        //can add a word
        wordsDict.addWord("anyone", DictionaryType.THIRD);
        String temp = THIRD_SENTENCE + "anyone";
        List<String> list = breakWords.breakTargetWords(temp, wordsDict.getWordDict(DictionaryType.THIRD));
        Assert.assertTrue(list.size() == 2);
        list.forEach(System.out::println);
    }
}
