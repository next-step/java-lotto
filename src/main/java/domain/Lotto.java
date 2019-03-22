package domain;

import util.WinType;

public class Lotto {
    private Numbers numbers;

    private Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    static Lotto of(Numbers numbers) {
        return new Lotto(numbers);
    }

    WinType figure(WinningLotto winningLotto) {
        return winningLotto.figure(this.numbers);
    }

    public Numbers getNumbers() {
        return this.numbers;
    }
}
