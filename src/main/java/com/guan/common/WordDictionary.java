package com.guan.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tiangang.Guan
 *  Singleton of dictionary
 */
public class WordDictionary {
    /**
     * default dictionary
     */
    private static final Set<String> DEFAULT_DICT = new HashSet<>(
        Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go")
    );
    private static final WordDictionary instance = new WordDictionary();
    private WordDictionary() {}

    public static WordDictionary getInstance() {
        return instance;
    }

    /**
     *  get the default dictionary
     *
     * @return default dictionary
     */
    public Set<String> getDefaultDictionary() {
        return DEFAULT_DICT;
    }
}
