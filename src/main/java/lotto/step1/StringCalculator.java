package lotto.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final Map<Character, BiFunction<Integer, Integer, Integer>> arithmeticOperation;
    private static final String NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE = "올바른 계산 식이 아닙니다. 다시 입력해 주세요.";
    
    static {
        arithmeticOperation = new HashMap<>();
        arithmeticOperation.put('+', Integer::sum);
        arithmeticOperation.put('-', (firstNumber, secondNumber) -> firstNumber - secondNumber);
        arithmeticOperation.put('*', (firstNumber, secondNumber) -> firstNumber * secondNumber);
        arithmeticOperation.put('/', new DivideStrategy());
    }
    
    public int calculate(String formula) throws IllegalArgumentException {
        checkCorrectFormula(formula);
        String[] split = getSplit(formula);
        return rotationCalculate(getNumbers(split), getSymbols(split));
    }
    
    private void checkCorrectFormula(String formula) throws IllegalArgumentException {
        Matcher matcher = Pattern.compile("[0-9]+(\\s[+\\-*/]\\s[0-9]+)*").matcher(formula);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE);
        }
    }
    
    private int rotationCalculate(int[] numbers, char[] symbols) throws IllegalArgumentException {
        for (int index = 0; index < symbols.length; index++) {
            numbers[index + 1] = arithmeticOperation.get(symbols[index]).apply(numbers[index], numbers[index + 1]);
        }
        return numbers[numbers.length - 1];
    }
    
    private char[] getSymbols(String[] split) {
        return IntStream.range(0, split.length)
                .filter(index -> index % 2 == 1)
                .mapToObj(index -> split[index])
                .collect(Collectors.joining())
                .toCharArray();
    }
    
    private int[] getNumbers(String[] split) {
        return IntStream.range(0, split.length)
                .filter(index -> index % 2 == 0)
                .map(index -> Integer.parseInt(split[index]))
                .toArray();
    }
    
    private String[] getSplit(String formula) {
        return formula.split(" ");
    }
}
