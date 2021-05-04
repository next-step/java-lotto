package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String input) {
        int sum = 0;

        if(input == null || input.isEmpty()){
            return 0;
        }

        String[] numbers = input.split(",|:");
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
