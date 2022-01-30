package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int calculate(List<String> number){
        int sum = number.stream().mapToInt(Integer::parseInt).sum();
        return sum;
    }

}
