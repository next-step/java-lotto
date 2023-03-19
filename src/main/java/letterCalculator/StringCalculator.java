package letterCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String inputString) {
        if (ifNullReturnZero(inputString)) {
            return 0;
        }

        String[] tokens = getSplit(inputString);

        inputValidCheck(tokens);
        return addNumbers(tokens);
    }

    private void inputValidCheck(String[] tokens) {
        if(!negativeInputNumberCheck(tokens)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean ifNullReturnZero(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return true;
        }
        return false;
    }

    private int addNumbers(String[] numbers) {
        int result;
        result = Integer.parseInt(numbers[0]);
        for(int i = 1; i < numbers.length; i++) {
            result = result + Integer.parseInt(numbers[i]);
        }

        return result;
    }

    private boolean negativeInputNumberCheck(String[] inputString){
        return Arrays.stream(inputString)
            .mapToInt(Integer::parseInt)
            .noneMatch(i -> i<0);
    }

    private String[] findNewDelimiter(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            return tokens;
        }
        return null;
    }

    public String[] getSplit(String inputString) {
        String[] tokens = findNewDelimiter(inputString);
        if(tokens == null) {
            tokens = inputString.split(",|:");
        }
        return tokens;
    }
}
