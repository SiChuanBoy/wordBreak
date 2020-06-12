import com.guan.common.WordsDict;
import com.guan.type.DictionaryType;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * Test this word dictionary
 * @author Tiangang.Guan
 */
public class DictTest {

    /**
     * Test the initialized value
     */
    @Test
    public void testTheDict(){
        WordsDict wordsDict =WordsDict.getInstance();
        Set<String> dict = wordsDict.getWordDict(DictionaryType.FIRST);
        System.out.println(dict.toString());
    }

    /**
     * test the add one word to dictionary
     */
    @Test
    public void testAddTheDictValue(){
        WordsDict wordsDict =WordsDict.getInstance();
        wordsDict.addWord("am",DictionaryType.FIRST);
        Set<String> dict = wordsDict.getWordDict(DictionaryType.FIRST);
        System.out.println(dict.toString());
    }

    /**
     * test the overload function
     */
    @Test
    public void testAddTheDictList(){
        String[] arr = {"Animal","SUN","instance","computer"};
        WordsDict wordsDict =WordsDict.getInstance();
        wordsDict.addWord(Arrays.asList(arr),DictionaryType.FIRST);
        //get first dict
        Set<String> dict = wordsDict.getWordDict(DictionaryType.FIRST);
        System.out.println(dict.toString());
    }

    /**
     * add other dictionary
     */
    @Test
    public void testAddTheDictList2(){
        String[] arr = {"Animal","SUN","instance","computer"};
        WordsDict wordsDict =WordsDict.getInstance();
        wordsDict.addWord(Arrays.asList(arr),DictionaryType.SECOND);
        //get first dict
        Set<String> dict = wordsDict.getWordDict(DictionaryType.SECOND);
        System.out.println(dict.toString());
    }
}
