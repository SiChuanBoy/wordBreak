package com.guan.impl;

import com.guan.IBreakWord;
import com.guan.common.BreakWordUtil;
import com.guan.common.WordDictionary;

import java.util.List;
import java.util.Set;
/**
 * Merge customize dictionary and default dictionary to assemble sentences
 * @author Tiangang.Guan
 */
public class MergeBreakWordImpl implements IBreakWord {
    @Override
    public List<String> breakWords(String source, Set<String> customizeDictionary) {
        Set<String> defaultWordDict = WordDictionary.getInstance().getDefaultDictionary();
        return BreakWordUtil.wordBreak(source, BreakWordUtil.addWord(defaultWordDict,customizeDictionary),0);
    }
}
