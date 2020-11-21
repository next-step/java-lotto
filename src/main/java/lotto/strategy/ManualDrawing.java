package lotto.strategy;

import java.util.Set;

public class ManualDrawing extends DrawingStrategy {
    private final static String INVALID_NUMBERS_MESSAGE = "유효하지 않은 로또 번호입니다.";
    private Set<Integer> numbers;

    public ManualDrawing(Set<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public Set<Integer> drawNumbers() {
        if(isInvalid(numbers)){
            throw new IllegalArgumentException(INVALID_NUMBERS_MESSAGE);
        }
        return numbers;
    }
}
