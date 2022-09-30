package lotto.step1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private static final String FORMULA_PATTERN = "[0-9]+(\\s[+\\-*/]\\s[0-9]+)*";
    private static final String DELIMITER = " ";
    private static final String NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE = "올바른 계산 식이 아닙니다. 다시 입력해 주세요.";
    
    public int calculate(String formula) {
        checkAllException(formula);
        String[] split = split(formula);
        return rotationCalculate(getNumbers(split), getOperation(split));
    }
    
    private void checkAllException(String formula) {
        checkNull(formula);
        checkCorrectFormula(formula);
    }
    
    private void checkNull(String formula) {
        if (formula == null) {
            throw new IllegalArgumentException(NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE);
        }
    }
    
    private void checkCorrectFormula(String formula) {
        Matcher matcher = Pattern.compile(FORMULA_PATTERN).matcher(formula);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_CORRECT_FORMULA_EXCEPTION_MESSAGE);
        }
    }
    
    private int rotationCalculate(List<Integer> numbers, List<Operation> operations) {
        return IntStream.range(0, operations.size())
                .reduce(numbers.get(0), (calculateResult, index) -> operations.get(index).calculate(calculateResult, numbers.get(index + 1)));
    }
    
    private List<Operation> getOperation(String[] split) {
        return IntStream.range(0, split.length)
                .filter(this::isOdd)
                .mapToObj(index -> split[index].charAt(0))
                .map(Operation::from)
                .collect(Collectors.toList());
    }
    
    private boolean isOdd(int index) {
        return index % 2 == 1;
    }
    
    private List<Integer> getNumbers(String[] split) {
        return IntStream.range(0, split.length)
                .filter(this::isEven)
                .mapToObj(index -> Integer.parseInt(split[index]))
                .collect(Collectors.toList());
    }
    
    private boolean isEven(int index) {
        return index % 2 == 0;
    }
    
    private String[] split(String formula) {
        return formula.split(DELIMITER);
    }
}
