package lotto.strategy;

import java.util.List;

public class ManualDrawing extends DrawingStrategy {
    private final static String INVALID_NUMBERS_MESSAGE = "유효하지 않은 로또 번호입니다.";
    private List<Integer> numbers;

    public ManualDrawing(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public List<Integer> drawNumbers(int numbersCount) {
        if(isInvalid(numbers, numbersCount)){
            throw new IllegalArgumentException(INVALID_NUMBERS_MESSAGE);
        }
        return numbers;
    }
}
