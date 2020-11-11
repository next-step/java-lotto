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
        return parseInt(input);
    }
}
