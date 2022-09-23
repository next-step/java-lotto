package lotto.step1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    public int calculate(String formula) {
        String[] split = formula.split(" ");
        return rotationCalculate(getNumbers(split), getSymbols(split));
    }
    
    private int rotationCalculate(int[] numbers, char[] symbols) {
        int result = 0;
        for (int index = 0; index < symbols.length; index++) {
            result = checkSymbolAndCalculate(numbers, symbols, index);
        }
        return result;
    }
    
    private int checkSymbolAndCalculate(int[] numbers, char[] symbols, int index) {
        if (symbols[index] == '+') {
            return numbers[index] + numbers[index + 1];
        }
    
        if (symbols[index] == '-') {
            return numbers[index] - numbers[index + 1];
        }
        
        return 0;
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
}
