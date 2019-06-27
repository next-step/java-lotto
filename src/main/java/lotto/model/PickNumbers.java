package lotto.model;

public class PickNumbers {

    private LottoNumbers numbers;

    public PickNumbers(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoRank match(WinningNumbers winnerNumbers) {
        return winnerNumbers.match(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(Number winningNumber) {
        return numbers.contains(winningNumber);
    }
}
