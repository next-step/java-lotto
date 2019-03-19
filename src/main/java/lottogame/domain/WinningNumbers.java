package lottogame.domain;

public class WinningNumbers {

    private final LottoGame numbers;

    public WinningNumbers(LottoGame numbers) {
        this.numbers = numbers;
    }

    public LottoGame getNumbers() {
        return numbers;
    }
}