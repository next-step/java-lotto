package lotto.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final Map<Character, BiFunction<Integer, Integer, Integer>> arithmeticOperation;
    
    static {
        arithmeticOperation = new HashMap<>();
        arithmeticOperation.put('+', Integer::sum);
        arithmeticOperation.put('-', (firstNumber, secondNumber) -> firstNumber - secondNumber);
        arithmeticOperation.put('*', (firstNumber, secondNumber) -> firstNumber * secondNumber);
        arithmeticOperation.put('/', new DivideStrategy());
    }
    
    public int calculate(String formula) throws UnsupportedOperationException {
        String[] split = getSplit(formula);
        return rotationCalculate(getNumbers(split), getSymbols(split));
    }
    
    private int rotationCalculate(int[] numbers, char[] symbols) throws UnsupportedOperationException {
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
