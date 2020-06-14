import com.guan.common.BreakWordUtil;
import com.guan.common.WordDictionary;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test the dictionary
 *
 * @author Tiangang.Guan
 */
public class DictionaryTest {

    /**
     * Test the default dictionary
     */
    @Test
    public void testDefaultDict() {
        WordDictionary wordDictionary = WordDictionary.getInstance();
        Set<String> dict = wordDictionary.getDefaultDictionary();
        Assert.assertTrue(dict.contains("cream"));
        System.out.println(dict.size());
        Assert.assertEquals(11, dict.size());
        System.out.println(dict.toString());
    }

    /**
     * test customize dictionary
     */
    @Test
    public void testDefaultAddCustomizeDict() {
        WordDictionary wordDictionary = WordDictionary.getInstance();
        Set<String> def = wordDictionary.getDefaultDictionary();
        //customize
        String[] additionDict = {"and", "apple", "HuaWei"};
        Set<String> set = BreakWordUtil.addWord(def, Arrays.asList(additionDict));
        Assert.assertTrue(set.contains("man"));
        Assert.assertTrue(set.contains("HuaWei"));
        Assert.assertTrue(def.size() + additionDict.length >= set.size());
        System.out.println("The number of prediction results:" + (def.size() + additionDict.length));
        System.out.println("The result size is :" + set.size());
        System.out.println(set.toString());
    }
}
