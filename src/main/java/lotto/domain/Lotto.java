package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createAutoLotto() {
        LottoNumbers lottoNumbers = LottoNumbers.createAutoLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public static Lotto createManualLotto(List<String> manualNumbers) {
        LottoNumbers lottoNumbers = LottoNumbers.createManualLottoNumbers(manualNumbers);
        return new Lotto(lottoNumbers);
    }

    public int findMatchingBall(Lotto winningLotto) {
        return lottoNumbers.findMatchingNumbers(winningLotto.getLottoNumbers());
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.hasLottoNumber(bonusNumber);
    }

    private LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }
}
