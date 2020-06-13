package com.guan.impl;

import com.guan.IBreakWord;
import com.guan.common.BreakWordUtil;

import java.util.List;
import java.util.Set;

/**
 * Custom dictionary to assemble sentences
 *
 * @author Tiangang.Guan
 */
public class CustomizeBreakWordImpl implements IBreakWord {

    @Override
    public List<String> breakWords(String source, Set<String> customizeDictionary) {
        if (null == customizeDictionary || customizeDictionary.isEmpty()) {
            throw new IllegalArgumentException("There are no elements in the dictionary!");
        }
        return BreakWordUtil.wordBreak(source, customizeDictionary, 0);
    }
}
