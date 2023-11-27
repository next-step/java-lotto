package lotto.domain;

import java.util.List;

public class Lotto {


    private LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public static Lotto of(int... numbers) {
        Lotto lotto = new Lotto();

        lotto.lottoNumbers = new LottoNumbers(numbers);
        return lotto;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public int getMatchCount(Lotto lastWeekWinningLotto) {
        return (int) lottoNumbers.getNumbers().stream()
                .filter(lastWeekWinningLotto.getLottoNumbers()::contains)
                .count();
    }
}
