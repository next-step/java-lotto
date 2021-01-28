package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    public Lotto(List<Integer> lottoNumbers) {

        this.numbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
