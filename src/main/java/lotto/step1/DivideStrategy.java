package lotto.step1;

import java.util.function.BiFunction;

public class DivideStrategy implements BiFunction<Integer, Integer, Integer> {
    private static final String DIVIDE_NUMBERS_EXCEPTION_MESSAGE = "나눗셈은 정확히 나누어 떨어지는 경우에만 진행할 수 있습니다. 다시 입력해주세요.";
    
    @Override
    public Integer apply(Integer firstNumber, Integer secondNumber) throws IllegalArgumentException {
        if (firstNumber / secondNumber != (double) firstNumber / secondNumber) {
            throw new IllegalArgumentException(DIVIDE_NUMBERS_EXCEPTION_MESSAGE);
        }
        return firstNumber / secondNumber;
    }
}
