import org.apache.commons.lang3.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        return StringUtils.isBlank(input)? 0 : add(Number.getTokens(input));
    }

    private static int add(Number number) {
        int sum = 0;
        for (String token : number.numbers) {
            sum += convertInt(token);
        }
        return sum;
    }

    private static int convertInt(String input) {
        int result = Integer.parseInt(input);
        if (result < 0) {
            throw new RuntimeException("음수는 지원하지 않습니다.");
        }
        return result;
    }
}
