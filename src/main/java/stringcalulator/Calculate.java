package stringcalulator;

import stringcalulator.model.Constant;
import stringcalulator.model.Operator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static stringcalulator.model.Constant.Exception.*;
import static stringcalulator.model.Constant.regexPattern.*;

public class Calculate {
    private final String[] characters;

    private static final Pattern OPERATORS = Pattern.compile(REGEX_OPERATOR);
    private static final Pattern INPUT_VALIDATION = Pattern.compile(REGEX_INPUT_VALIDATION);
    private Queue<Double> numberQueue = new LinkedList<>();
    private Queue<String> operatorQueue = new LinkedList<>();

    public Calculate(String formula) {
        Matcher matcher = INPUT_VALIDATION.matcher(formula);
        if (!matcher.find()) {
            throw new IllegalArgumentException(DOES_NOT_NUMBER_AND_SYMBOL);
        }
        this.characters = formula.split(" ");
    }

    public void operate() {
        separateFormula();
    }

    public Double getResult() {
        Double result = numberQueue.poll();
        int queueSize = numberQueue.size();
        for (int i = 0; i < queueSize; i++) {
            String operator = operatorQueue.poll();
            Operator operator1 = Operator.findOperator(operator);

            result = operator1.operate(result, numberQueue.poll());
        }
        return result;
    }

    public void separateFormula() {
        for (String character : characters) {
            Matcher regexMatcher = OPERATORS.matcher(character);
            if (regexMatcher.find()) {
                operatorQueue.add(character);
                continue;
            }

            numberQueue.add(Double.parseDouble(character));
        }
    }
}
