package step1.number;

import java.util.List;

public final class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        if(isNull(numbers)) {
            throw new IllegalArgumentException("null 값을 입력했습니다.");
        }
        this.numbers = numbers;
    }

    private final boolean isNull(List<Number> numbers){
        return numbers == null;
    }
}
