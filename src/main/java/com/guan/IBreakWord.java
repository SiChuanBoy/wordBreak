package com.guan;

import java.util.List;
import java.util.Set;

/**
 * @author TianGang.Guan
 * it's a interface to split the string that is add space to be a sentence
 */
public interface IBreakWord {

    /**
     * Split a string into a sentence by dictionary
     *
     * @param source     string
     * @param dictionary dictionary
     * @return List<String><br/> list of sentence
     */
    List<String> breakWords(String source, Set<String> dictionary);
}
