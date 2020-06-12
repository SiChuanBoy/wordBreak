package com.guan.common;

import com.guan.type.DictionaryType;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tiangang.guan
 * This is a dictionary, a dictionary of words.<br/>
 * it is a Singleton
 */
public class WordsDict {
    /**
     * wordDict is a word list
     */
    private static Set<String> firstWordDict = new HashSet<>();
    private static Set<String> secondWordDict = new HashSet<>();
    private static Set<String> thirdWordDict = new HashSet<>();

    //init the words dict
    static {
        //we need this word as our word dictionary
        String[] first = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go"};
        firstWordDict.addAll(Arrays.asList(first));

        /**
         * this is my dictionary
         */
        String[] second = {"i", "like", "sam", "sung", "mobile", "apple", "man", "go", "mango","and"};
        secondWordDict.addAll(Arrays.asList(second));

        String[] third = {"i", "like", "sam", "sung",  "mobile", "icecream", "man", "go", "mango"};
        thirdWordDict.addAll(Arrays.asList(third));
    }

    private static WordsDict instance = new WordsDict();

    private WordsDict() {
    }

    public static WordsDict getInstance() {
        return instance;
    }

    /**
     * get the list of dictionary
     *
     * @return the value list
     */
    public Set<String> getWordDict(DictionaryType type) {
        Set<String> last = new HashSet<>();
        switch (type) {
            case FIRST:
                last = firstWordDict;
                break;
            case SECOND:
                last = secondWordDict;
                break;
            case THIRD:
                last = thirdWordDict;
                break;
            default: {

            }
        }
        return last;
    }

    /**
     * can add extra word
     *
     * @param word need to add( not null)
     */
    public void addWord(String word, DictionaryType type) {
        if (null == word) {
            return;
        }
        getWordDict(type).add(word);
    }

    public void addWord(Collection<String> extraWords, DictionaryType type) {
        if (null == extraWords) {
            return;
        }
        if (extraWords.size() < 1) {
            return;
        }
        getWordDict(type).addAll(extraWords);
    }
}
