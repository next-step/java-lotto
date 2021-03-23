package lotto.domain;

import java.util.ArrayList;

public class LottoGame {
    private Numbers numbers;

    public LottoGame() {
        this(new Numbers(new ArrayList<>()));
    }

    public LottoGame(Numbers numbers) {
        this.numbers = numbers;
    }

    public void makeNumbers() {
        numbers = NumberGenerator.creation();
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public HitResult lotto(WinNumbers winNumbers) {
        return new HitResult(numbers, winNumbers);
    }
}
