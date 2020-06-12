package com.guan.common;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Tiangang.guan
 *  offer some function to solve the problem
 */
public class WordBreakFunction {

    /**
     *  Backtracking function to break the words
     * @param source need to split
     * @param wordDict dictionary
     * @param start start to look for
     * @return target, the result, that had split
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
                //call the traceback function to check whether the remaining part of the string can form an effective split
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
     * spilt the string to be a sentence by dictionary word
     * @param source the needs
     * @param wordDict the dictionary
     * @return the last result
     */
    public static List<String> wordBreakOther(String source, Set<String> wordDict) {
        //definition n+1 size array named dp
        CopyOnWriteArrayList<String>[] dp = new CopyOnWriteArrayList[source.length() + 1];
        CopyOnWriteArrayList<String> initial = new CopyOnWriteArrayList<>();
        //dp[0] is empty string when  initialized
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= source.length(); i++) {
            CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
            for (int j = 0; j < i; j++) {
                //when dp[j] is not empty and substring was included，add word to dp
                if (dp[j].size() > 0 && wordDict.contains(source.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + source.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[source.length()];
    }
}
