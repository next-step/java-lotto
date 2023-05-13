import jdk.dynalink.Operation;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static final String REGEX = " ";
    static final String VALIDATION_PATTERN = "^[+\\-*/\\d]*$";
    static final String NUMBER_PATTERN = "^[0-9]*$";
    static final String OPERATOR_PATTERN = "[+\\-*/]";

    static final Pattern validationPattern = Pattern.compile(VALIDATION_PATTERN);
    static final Pattern numberPattern = Pattern.compile(NUMBER_PATTERN);
    static final Pattern operatorPattern = Pattern.compile(OPERATOR_PATTERN);

    private Deque<String> numberQueue = new LinkedList<>();
    private Queue<String> operatorQueue = new LinkedList<>();

    public double calculate(String input) {
        String[] splitedInput = split(input, REGEX);

        for (String s : splitedInput) {
            initOperator(s);
        }

        double resultString = 0;
        while (numberQueue.size() > 1) {
            double number1 = Double.parseDouble(numberQueue.poll());
            double number2 = Double.parseDouble(numberQueue.poll());
            String operatorString = operatorQueue.poll();

            Operator operator = Operator.pars(operatorString);

            resultString = operator.calculate(number1, number2);
            numberQueue.addFirst(String.valueOf(resultString));
        }

        return resultString;
    }

    public void initOperator(String input) {
        Matcher numberMatcher = numberPattern.matcher(input);
        Matcher operatorMatcher = operatorPattern.matcher(input);

        addNumber(input, numberMatcher);
        addOperator(input, operatorMatcher);
    }

    private void addOperator(String input, Matcher operatorMatcher) {
        if (operatorMatcher.find()) {
            operatorQueue.add(input);
        }
    }

    private void addNumber(String input, Matcher numberMatcher) {
        if (numberMatcher.find()) {
            numberQueue.add(input);
        }
    }

    public String[] split(String input, String regex) {
        return input.split(regex);
    }

    public void validation(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("null이거나 공백입니다.");
        }

        Matcher matcher = validationPattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("숫자나 연산자가 아닙니다.");
        }
    }
}
