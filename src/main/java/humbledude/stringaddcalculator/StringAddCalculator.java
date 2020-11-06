package humbledude.stringaddcalculator;

public class StringAddCalculator {

    private static final String DEAFAULT_SPLIT_TOKEN = ",|;";

    public static int splitAndSum(String input) {
        int sum = 0;
        if (!isValidInput(input)) {
            return sum;
        }

        String[] strNumbers = input.split(DEAFAULT_SPLIT_TOKEN);

        for (String strNumber : strNumbers) {
            int number = parseInt(strNumber);
            validateNumber(number);
            sum += number;
        }

        return sum;
    }

    private static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }
        if (input.isEmpty()) {
            return false;
        }

        return true;
    }

    private static int parseInt(String strNumber) {
        int number;
        try {
            number = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 문자가 입력됨");
        }

        return number;
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 지원하지 않습니다");
        }
    }
}
