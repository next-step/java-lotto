package step1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operators {
    private static final String OPERATOR_PATTERN = "[+*/-]";
    private static final String DIGIT = "\\d";
    private static final String NOT_OPERATOR_PATTERN = "사칙연산 기호가 아닙니다";

    private Queue<String> operators = new LinkedList<>();

    public Operators(String input) {
        Matcher matcher = Pattern.compile(OPERATOR_PATTERN).matcher(input);
        while(matcher.find()) {
            operators.add(matcher.group());
        }

        String s = input.replaceAll(OPERATOR_PATTERN, "");
        String s1 = s.replaceAll("", "");
        if(!Pattern.compile(DIGIT).matcher(s1).matches()) {
            throw new IllegalArgumentException(NOT_OPERATOR_PATTERN);
        }
    }

    public void add(String input) {
        operators.add(input);
    }

    public String peek() {
        return operators.poll();
    }
}
