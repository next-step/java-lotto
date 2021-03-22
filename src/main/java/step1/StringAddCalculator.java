package step1;

import java.util.Arrays;

public class StringAddCalculator {

    public StringAddCalculator(){

    }

    public int sum(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }
        return Arrays.stream(input.split(",|:"))
                .mapToInt(i-> Integer.parseInt(i))
                .sum();
    }
}
