package step1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operators {
    private static final String OPERATOR_PATTERN = "[+*/-]";
    private static final String EXTRACT_CHAR_PATTERN = "([0-9]+ [-+*/] )+[0-9]";
    private static final String NOT_OPERATOR_PATTERN = "사칙연산 기호가 아닙니다";

    private Queue<String> operators = new LinkedList<>();

    public Operators(String input) {
        Matcher matcher = Pattern.compile(OPERATOR_PATTERN).matcher(input);
        while(matcher.find()) {
            operators.add(matcher.group());
        }

        String extractChar = Pattern.compile(EXTRACT_CHAR_PATTERN).matcher(input).replaceAll("");
        if(!extractChar.isEmpty())
            throw new IllegalArgumentException(NOT_OPERATOR_PATTERN);
    }

    public void add(String input) {
        operators.add(input);
    }

    public String peek() {
        return operators.poll();
    }
}
