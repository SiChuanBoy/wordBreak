package com.guan;

import java.util.List;
import java.util.Set;

/**
 * @author TianGang.Guan
 * it's a interface to split the string that is add space to be a sentence
 */
public interface BreakWords {
    /**
     *
     * @param source this is a  no space String
     * @param wordDict this is the dictionary of word
     * @return List<String> the break result.<br />
     */
    List<String> breakTargetWords(String source, Set<String> wordDict);
}
