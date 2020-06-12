package com.guan.common;

import com.guan.BreakWords;
import com.guan.imple.BreakWordArrayImple;
import com.guan.imple.BreakWordsImple;
import com.guan.type.DictionaryType;

/**
 * create the solution of words
 */
public class CreateSolutionFactory {

    /**
     * Provide a simple factory method to create and implement
     * @param type the stage type
     * @return the implement
     */
    public  static BreakWords getSolution(DictionaryType type){
        switch (type){
            case FIRST:
                return new BreakWordsImple();
            case SECOND:
            case THIRD:
                return new BreakWordArrayImple();
            default:
        }
        return null;
    }


}
