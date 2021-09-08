package lotto;


public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoRank checkWinning(LottoNumbers winningNumbers) {
        int equalNumberCount = numbers.equalNumberCount(winningNumbers);
        return LottoRank.valueOf(equalNumberCount);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
