package lotto.step1.model;

import java.util.List;

public class NonNegativeIntegers {

    private List<NonNegativeInteger> nonNegativeIntegers;

    public NonNegativeIntegers(String[] integers){
        for(int i = 0; i < integers.length; i++){
            nonNegativeIntegers.add(new NonNegativeInteger(integers[i]));
        }
    }

    public NonNegativeInteger sum(){
        return nonNegativeIntegers.stream()
                     .reduce(new NonNegativeInteger(),NonNegativeInteger::sum);
    }

}
