package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    protected String[] remover(Integer elementsRemoved, boolean[] dontCopy){
        String[] newArr = new String[array.length - elementsRemoved];
        Integer index = 0;
        for(int i = 0; i < array.length; i++){
            if(!dontCopy[i]){
                newArr[index] = array[i];
                index++;
            }
        }
        return newArr;
    }
}
