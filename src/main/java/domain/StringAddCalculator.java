package domain;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if(input == null){
            return 0;
        }
        if(input.isEmpty()){
            return 0;
        }
        String[] split = input.split(",");

        int sum = 0;
        for (String s : split) {
            sum += parseInt(s);
        }
        return sum;
    }
}
