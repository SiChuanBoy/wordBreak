package com.guan.impl;

import com.guan.IBreakWord;
import com.guan.common.BreakWordUtil;
import com.guan.common.WordDictionary;

import java.util.List;
import java.util.Set;

/**
 * Default dictionary to assemble sentences
 *
 * @author Tiangang.Guan
 */
public class DefaultBreakWordImpl implements IBreakWord {
    @Override
    public List<String> breakWords(String source, Set<String> defaultDict) {
        if (null == defaultDict || defaultDict.isEmpty()) {
            defaultDict = WordDictionary.getInstance().getDefaultDictionary();
        }
        return BreakWordUtil.wordBreak(source, defaultDict, 0);
    }
}
