package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto initLotto() {
        LottoNumbers lottoNumbers = LottoNumbers.initShuffledLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public static Lotto initWinningLotto(List<String> manualNumbers) {
        LottoNumbers lottoNumbers = LottoNumbers.initManualLottoNumbers(manualNumbers);
        return new Lotto(lottoNumbers);
    }

    public int findMatchingBall(Lotto winningLotto) {
        return lottoNumbers.findMatchingNumbers(winningLotto.getLottoNumbers());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoSize() {
        return lottoNumbers.getLottoNumberSize();
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }
}
