import com.guan.IBreakWord;
import com.guan.common.BreakWordUtil;
import com.guan.type.OperateType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * test sentence
 * @author Tiangang.Guan
 */
public class BreakWordTest{

    //default input
    public final static String DEFAULT_SENTENCE_INPUT = "ilikesamsungmobile";
    //Possible result
    public final static String DEFAULT_SENTENCE_RESULT_I = "i like sam sung mobile";
    public final static String DEFAULT_SENTENCE_RESULT_II = "i like samsung mobile";

    //default input
    public final static String DEFAULT_SENTENCE_INPUT_I = "ilikeicecreamandmango";
    public final static String DEFAULT_SENTENCE_OUT = "i like ice cream and man go";

    /**
     * test the default dictionary
     */
    @Test
    public void tetDefaultSentence(){
        System.out.println("===start test the first default string===");
        IBreakWord breakWord = BreakWordUtil.createBreakWord(OperateType.DEFAULT);
        //get default the first string
        List<String> strings = breakWord.breakWords(DEFAULT_SENTENCE_INPUT, null);
        assertEquals(2, strings.size());
        assertTrue(strings.contains(DEFAULT_SENTENCE_RESULT_I) && strings.contains(DEFAULT_SENTENCE_RESULT_II));
        strings.forEach(System.out::println);
    }

    @Test
    public void tetDefaultSentenceExtra(){
        IBreakWord breakWord = BreakWordUtil.createBreakWord(OperateType.DEFAULT);
        System.out.println("===start test the second default string===");
        //get default the second string
        List<String> strings = breakWord.breakWords(DEFAULT_SENTENCE_INPUT_I, null);
        assertEquals(1, strings.size());
        assertTrue(strings.contains(DEFAULT_SENTENCE_OUT));
        strings.forEach(System.out::println);
    }


    @Test
    public void testCustomizeSentence() {
        System.out.println("===start test the customize dictionary and customize string===");
        IBreakWord breakWord = BreakWordUtil.createBreakWord(OperateType.CUSTOMIZE);
        Set<String> customizeDictionary = new HashSet<>(
            Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango", "and","apple","huawei"));
        String string = "ilikemangoandapple";
        String result = "i like mango and apple";
        List<String> list = breakWord.breakWords(string, customizeDictionary);
        assertEquals(1, list.size());
        assertEquals(result,list.get(0));
        list.forEach(System.out::println);
    }


    @Test
    public void testMergeSentence() {
        System.out.println("===start test the merge customize dictionary and default dictionary===");
        IBreakWord breakWord = BreakWordUtil.createBreakWord(OperateType.MERGE);
        Set<String> customizeDictionary = new HashSet<>(
                Arrays.asList("apple","huawei","phone","is"));
        String customizeString = "appleandhuaweiisphoneilike";
        String result = "apple and huawei is phone i like";
        List<String> list = breakWord.breakWords(customizeString, customizeDictionary);
        assertEquals(1, list.size());
        assertEquals(result,list.get(0));
        list.forEach(System.out::println);
    }

}
