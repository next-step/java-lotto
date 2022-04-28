package lottoauto;

import java.util.List;

public class Lotto {
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
