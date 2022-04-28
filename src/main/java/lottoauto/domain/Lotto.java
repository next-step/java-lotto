package lottoauto.domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> inputNumbers) {
        if(inputNumbers.size() > 6){
            throw new IllegalArgumentException("로또의 숫자는 6개 입니다.");
        }
        this.numbers = inputNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
