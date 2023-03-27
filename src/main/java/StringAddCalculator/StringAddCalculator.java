package StringAddCalculator;


import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public void start() {

        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열 입력");
        String input = sc.nextLine().replaceAll("\\\\n", "\n");
        System.out.println("결과"+getResult(input));
    }

    public int getResult(String input) {
        String[] spiltStrings = splitNumber(vaildateInput(input));
        int[] numbersArr = Arrays.stream(spiltStrings)
                                .mapToInt(Integer::parseInt)
                                .toArray();

        Arrays.stream(numbersArr)
                .filter(number -> (number < 0))
                .forEach( number -> { throw new RuntimeException("음수불가능");});

        return addNumbers(numbersArr);
    }

    private String vaildateInput(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }

        return input;
    }

    private String[] splitNumber(String input) {

        if (input.length() == 0) {
            return new String[]{input};
        }

        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(delimiter);
        }

        return input.split(DELIMITER);
    }

    private int addNumbers(int[] numbersArr) {
        return Arrays.stream(numbersArr).reduce(0, Integer::sum);
    }

}

