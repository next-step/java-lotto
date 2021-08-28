package lotto.domain;

import java.util.List;

public class WinLotto {

    private final Numbers numbers;

    public WinLotto(List<Number> numbers) {
        this.numbers = new Numbers(numbers);
    }

}
