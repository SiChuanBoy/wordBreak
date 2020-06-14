package com.guan.common;

import com.guan.IBreakWord;
import com.guan.impl.CustomizeBreakWordImpl;
import com.guan.impl.DefaultBreakWordImpl;
import com.guan.impl.MergeBreakWordImpl;
import com.guan.type.OperateType;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Tiangang.guan
 * Work Break Util
 */
public class BreakWordUtil {

    /**
     * Backtrack call
     * @param source   source string
     * @param wordDict dictionary
     * @param start    start to look for
     * @return List<String></> the result
     */
    public static List<String> wordBreak(String source, Set<String> wordDict, int start) {
        CopyOnWriteArrayList<String> target = new CopyOnWriteArrayList<>();
        //If the detected string is empty, the returned result is added with an empty string
        if (start == source.length()) {
            target.add("");
        }
        for (int end = start + 1; end <= source.length(); end++) {
            //check the words,if source exist and in the dictionary,continue and add the result
            if (wordDict.contains(source.substring(start, end))) {
                //call the backtrack function to check whether the remaining part of the string can form an effective split
                List<String> list = wordBreak(source, wordDict, end);
                for (String l : list) {
                    //add the word into result!
                    target.add(source.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return target;
    }

    /**
     * Get policy class
     * @param type operate type
     * @return IBreakWord
     */
    public static IBreakWord createBreakWord(OperateType type) {
        IBreakWord breakWord = null;
        switch (type) {
            case DEFAULT:
                breakWord = new DefaultBreakWordImpl();
                break;
            case CUSTOMIZE:
                breakWord = new CustomizeBreakWordImpl();
                break;
            case MERGE:
                breakWord = new MergeBreakWordImpl();
                break;
        }
        return breakWord;
    }


    /**
     * add extra dictionary to customized dictionary
     *
     * @param defaultDict    default dictionary
     * @param customizedDict customized dictionary
     * @return the last dictionary list
     */
    public static Set<String> addWord(Set<String> defaultDict, Collection<String> customizedDict) {
        if (null == customizedDict || customizedDict.isEmpty()) {
            throw new IllegalArgumentException("Cannot add this collection to set,it's null or empty!");
        }
        Set<String> last = new HashSet<>(defaultDict);
        last.removeIf(test -> test.equals(""));
        last.addAll(customizedDict);
        return last;
    }
}
