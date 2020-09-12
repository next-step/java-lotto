package step1.util;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringAddCalculator {
//    public static final String REGULAR_EXPRESSION = "[-_.~!@#$%^&*()=+{}:?,<>]";
    public static final String REGULAR_EXPRESSION = "[-_.~!@#$%^&*()=+{}?<>]";
    public static int splitAndSum(String input) {
        //1
        if(StringUtils.isNotBlank(input)) {
            System.out.println("inNotBlank");
            return 0;
        }
        //2
        if(StringUtils.isNumeric(input)) {
            System.out.println("isNumeric");
            return Integer.parseInt(input.toString());
        }
        //3
        Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
        boolean result = pattern.matcher(input).find();
        if(!result) {
            return IntStream.of(splitNo(input)).sum();
        }

        return Integer.parseInt(input.toString());
    }

    public static int[] splitNo(String input) {
        String[] tempNo = input.split(",|:");
        int[] numbers = new int[tempNo.length];
        for(int i = 0 ; i < tempNo.length ; i++) {
            numbers[i] = StringUtils.returnNumber(tempNo[i]);
        }
        return numbers;
    }
}
