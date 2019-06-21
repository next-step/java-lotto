import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String stringNumber) {
        if(stringNumber == null || stringNumber.trim().isEmpty()){
            return 0;
        }

        Matcher customPattern = Pattern.compile("//(.)\n(.*)").matcher(stringNumber);
        if (customPattern.find()) {
            String customDelimiter = customPattern.group(1);
            List <String> numbers = Arrays.asList(customPattern.group(2).split(customDelimiter));

            for (String number : numbers) {
                try {
                    if (Integer.parseInt(number) < 0) {
                        System.out.println("1");
                        throw new RuntimeException("입력 값에 음수가 포함 되어 있습니다.");
                    }
                } catch (NumberFormatException e) {
                    throw new RuntimeException("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
                }
            }

            return numbers.stream()
                            .mapToInt(Integer::parseInt)
                            .sum();
        }

        List<String> numbers = Arrays.asList(stringNumber.split(",|;"));
        if(numbers.size() > 1){
            for (String number : numbers) {
                try {
                    if (Integer.parseInt(number) < 0) {
                        throw new RuntimeException("입력 값에 음수가 포함 되어 있습니다.");
                    }
                } catch (NumberFormatException e) {
                    throw new RuntimeException("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
                }
            }

            return numbers.stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        try {
            return Integer.parseInt(stringNumber);
        }catch(Exception e){
            throw new RuntimeException("입력 값에 숫자 아닌 다른 문자가 포함 되어 있습니다.");
        }

    }
}
