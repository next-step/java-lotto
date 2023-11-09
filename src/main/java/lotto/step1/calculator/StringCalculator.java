package lotto.step1.calculator;

public class StringCalculator {
    public static String calculate(final String[] split) {
        String answer = "";

        for (int i = 0; i < split.length; i++) {
            final String curString = split[i];
            final String nextString = split[i + 1];

            if ("+".equals(curString)) {
                answer = sum(answer, nextString);
                i++;
            } else {
                answer = curString;
            }
        }

        return answer;
    }

    private static String sum(final String num1, final String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }
}
