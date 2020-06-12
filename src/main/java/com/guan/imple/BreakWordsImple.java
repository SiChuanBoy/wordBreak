package com.guan.imple;

import com.guan.BreakWords;
import com.guan.common.WordBreakFunction;

import java.util.List;
import java.util.Set;

public class BreakWordsImple implements BreakWords {
    @Override
    public List<String> breakTargetWords(String source, Set<String> wordDict) {
        return WordBreakFunction.wordBreak(source,wordDict,0);
    }
}
