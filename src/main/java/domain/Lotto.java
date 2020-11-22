package domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto (LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int matchLottoNumbers(LottoNumbers winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        return (int) lottoNumbers.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

}
