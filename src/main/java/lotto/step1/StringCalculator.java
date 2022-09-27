package lotto.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final Map<Character, BiFunction<Integer, Integer, Integer>> ARITHMETIC_OPERATION;
    private static final String FORMULA_PATTERN = "[1-9][0-9]*(\\s[+\\-*/]\\s[1-9][0-9]*)*";
    private static final String DELIMITER = " ";
    private static final String NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE = "올바른 계산 식이 아닙니다. 다시 입력해 주세요.";
    
    static {
        ARITHMETIC_OPERATION = new HashMap<>();
        ARITHMETIC_OPERATION.put('+', Integer::sum);
        ARITHMETIC_OPERATION.put('-', (firstNumber, secondNumber) -> firstNumber - secondNumber);
        ARITHMETIC_OPERATION.put('*', (firstNumber, secondNumber) -> firstNumber * secondNumber);
        ARITHMETIC_OPERATION.put('/', new DivideStrategy());
    }
    
    public int calculate(String formula) throws IllegalArgumentException {
        checkAllException(formula);
        return rotationCalculate(getNumbers(getSplit(formula)), getSymbols(getSplit(formula)));
    }
    
    private void checkAllException(String formula) throws IllegalArgumentException {
        nullCheck(formula);
        checkCorrectFormula(formula);
    }
    
    private void nullCheck(String formula) throws IllegalArgumentException {
        if (formula == null) {
            throw new IllegalArgumentException(NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE);
        }
    }
    
    private void checkCorrectFormula(String formula) throws IllegalArgumentException {
        Matcher matcher = Pattern.compile(FORMULA_PATTERN).matcher(formula);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE);
        }
    }
    
    private int rotationCalculate(int[] numbers, char[] symbols) throws IllegalArgumentException {
        for (int index = 0; index < symbols.length; index++) {
            numbers[index + 1] = ARITHMETIC_OPERATION.get(symbols[index]).apply(numbers[index], numbers[index + 1]);
        }
        return numbers[numbers.length - 1];
    }
    
    private char[] getSymbols(String[] split) {
        return IntStream.range(0, split.length)
                .filter(this::isOdd)
                .mapToObj(index -> split[index])
                .collect(Collectors.joining())
                .toCharArray();
    }
    
    private boolean isOdd(int index) {
        return index % 2 == 1;
    }
    
    private int[] getNumbers(String[] split) {
        return IntStream.range(0, split.length)
                .filter(this::isEven)
                .map(index -> Integer.parseInt(split[index]))
                .toArray();
    }
    
    private boolean isEven(int index) {
        return index % 2 == 0;
    }
    
    private String[] getSplit(String formula) {
        return formula.split(DELIMITER);
    }
}
