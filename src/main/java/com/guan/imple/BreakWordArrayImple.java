package com.guan.imple;

import com.guan.BreakWords;
import com.guan.common.WordBreakFunction;

import java.util.List;
import java.util.Set;

/**
 * add spaces to fill the string and become a normal sentence
 * @author Tiangang.guan
 */
public class BreakWordArrayImple implements BreakWords {
    @Override
    public List<String> breakTargetWords(String source, Set<String> wordDict) {
        return WordBreakFunction.wordBreakOther(source,wordDict);
    }
}
