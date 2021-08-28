package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {

    private NumbersGenerator() {
    }

    public static List<Number> generateNumbers(String[] inputs) {
        List<Number> numbers = new ArrayList<>();
        for(int i=0; i<inputs.length; i++){
            numbers.add(new Number(Integer.parseInt(inputs[i])));
        }
        return numbers;
    }

}
