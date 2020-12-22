import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        int sum = 0;
        if (input == null) {
            return sum = 0;
        }
        if (input.isEmpty()) {
            return sum = 0;
        }
        if (input.length() == 1) {
            return sum = Integer.parseInt(input);
        }

        if (input.length() > 1 && input.contains(",")) {
            if (input.contains(":")) {
                String[] tokens = input.split(",|:");
                for (String num : tokens) {
                    sum += Integer.parseInt(num);
                }
                return sum;
            }

            String[] numbers = input.split(",");
            for (String num : numbers) {
<<<<<<< HEAD
                if (Integer.parseInt(num) < 0) {
                    throw new RuntimeException("음수가 전달되었습니다.");
                }
                if (!Pattern.matches("^0-9*$", num)) {
                    throw new RuntimeException("숫자 이외의 값이 전달되었습니다.");
                }
=======
>>>>>>> 1f087d48b98e01e814ed1c6e7b30a7f7decf9080
                sum += Integer.parseInt(num);
            }
            return sum;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            for (String num:tokens) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }

        return 0;
    }
}
