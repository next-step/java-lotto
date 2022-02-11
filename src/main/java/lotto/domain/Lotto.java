package lotto.domain;

import java.util.List;

public class Lotto {
    
    private final List<Integer> numbers;
    
    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
}
