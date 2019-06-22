package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications){
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
        return remover(elementsRemoved, dontCopy);
    }


    public T[] removeDuplicatesExactly(int exactNumberOfDuplications){
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
        return remover(elementsRemoved, dontCopy);
    }

    abstract protected T[] remover(Integer elementsRemoved, boolean[] dontCopy);



}
