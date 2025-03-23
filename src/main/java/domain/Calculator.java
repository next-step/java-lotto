package domain;

public class Calculator {

    public static int calculate(String string) {
        int answer = 0;
        String[] split = string.split(" ");
        for (String s : split) {
            if (s.equals("+")) {
                continue;
            }
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}
