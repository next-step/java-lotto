package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public StringAddCalculator() {
//        validate(input);
        Validate validate = new Validate() {
            @Override
            public int validateInput_Null(String input) {

                return 0;
            }

            @Override
            public int validateInput_OneNumber(String input) {
                return 0;
            }

            @Override
            public int validateInput_NegativeNumber(String input) {
                return 0;
            }
        };
    }

    public static int splitAndSum(String input) {

        if(input == null || input.trim().isEmpty()){
            return 0;
        }
        if(input.length() == 1){
            return Integer.parseInt(input);
        }
        String inputs[];
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if(m.find()){
            String customDelimiter = m.group(1);
            System.out.println(customDelimiter);
            inputs  =m.group(2).split(customDelimiter);

        }else
            inputs = input.split(",|:");

        boolean isNegative = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(element -> element >=0);

        if(!isNegative){
           throw new RuntimeException("ERR!!!");
        }


        return StringAddCalculator.elementSum(inputs);
    }

    static int elementSum(String inputs[]){
        int sum = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .reduce(0,Integer::sum);

        return sum;
    }
}


