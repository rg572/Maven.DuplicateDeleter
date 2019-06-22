package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        boolean[] dontCopy = new boolean[array.length];
        boolean[] beenChecked = new boolean[array.length];
        Integer elementsRemoved = 0;

        for(int i = 0; i < array.length; i++){
            if(!beenChecked[i]){
                Integer numberOfDuplicates = 1;
                for(int j = i+1; j < array.length; j++){
                    if(array[j].equals(array[i])){
                        numberOfDuplicates++;
                        beenChecked[j] = true;
                    }
                }
                if(numberOfDuplicates >= maxNumberOfDuplications){
                    elementsRemoved += numberOfDuplicates;
                    for(int j = i; j < array.length; j++){
                        if(array[j].equals(array[i])){
                            dontCopy[j] = true;
                        }
                    }
                }
            }
        }

//        Integer[] newArr = new Integer[array.length - elementsRemoved];
//        Integer index = 0;
//        for(int i = 0; i < array.length; i++){
//            if(!dontCopy[i]){
//                newArr[index] = array[i];
//                index++;
//            }
//        }
//
//        return newArr;
        return remover(elementsRemoved, dontCopy);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        boolean[] dontCopy = new boolean[array.length];
        boolean[] beenChecked = new boolean[array.length];
        Integer elementsRemoved = 0;

        for(int i = 0; i < array.length; i++){
            if(!beenChecked[i]){
                Integer numberOfDuplicates = 1;
                for(int j = i+1; j < array.length; j++){
                    if(array[j].equals(array[i])){
                        numberOfDuplicates++;
                        beenChecked[j] = true;
                    }
                }
                if(numberOfDuplicates == exactNumberOfDuplications){
                    elementsRemoved += numberOfDuplicates;
                    for(int j = i; j < array.length; j++){
                        if(array[j].equals(array[i])){
                            dontCopy[j] = true;
                        }
                    }
                }
            }
        }

//        Integer[] newArr = new Integer[array.length - elementsRemoved];
//        Integer index = 0;
//        for(int i = 0; i < array.length; i++){
//            if(!dontCopy[i]){
//                newArr[index] = array[i];
//                index++;
//            }
//        }
//
//        return newArr;
        return remover(elementsRemoved, dontCopy);
    }

    protected Integer[] remover(Integer elementsRemoved, boolean[] dontCopy){
        Integer[] newArr = new Integer[array.length - elementsRemoved];
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
