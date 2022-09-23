package lotto.step1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final String DIVIDE_NUMBERS_EXCEPTION_MESSAGE = "나눗셈은 정확히 나누어 떨어지는 경우에만 진행할 수 있습니다. 다시 입력해주세요.";
    
    public int calculate(String formula) throws UnsupportedOperationException {
        String[] split = getSplit(formula);
        return rotationCalculate(getNumbers(split), getSymbols(split));
    }
    
    private int rotationCalculate(int[] numbers, char[] symbols) throws UnsupportedOperationException {
        for (int index = 0; index < symbols.length; index++) {
            numbers[index + 1] = checkSymbolAndCalculate(numbers, symbols, index);
        }
        return numbers[numbers.length - 1];
    }
    
    private int checkSymbolAndCalculate(int[] numbers, char[] symbols, int index) throws UnsupportedOperationException {
        if (symbols[index] == '+') {
            return numbers[index] + numbers[index + 1];
        }
        
        if (symbols[index] == '-') {
            return numbers[index] - numbers[index + 1];
        }
        
        if (symbols[index] == '*') {
            return numbers[index] * numbers[index + 1];
        }
        
        checkCorrectDivideNumbers(numbers[index], numbers[index + 1]);
        return numbers[index] / numbers[index + 1];
    }
    
    private void checkCorrectDivideNumbers(int firstNumber, int secondNumber) throws UnsupportedOperationException {
        if (firstNumber / secondNumber != (double) firstNumber / secondNumber) {
            throw new UnsupportedOperationException(DIVIDE_NUMBERS_EXCEPTION_MESSAGE);
        }
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
