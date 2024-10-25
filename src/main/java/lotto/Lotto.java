package lotto;

import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;
    private LottoResult lottoResult;

    public Lotto() {
        createLotto(new LottoNumbers(), new LottoResult());
    }

    public Lotto(List<Integer> lottoNumbers) {
        createLotto(new LottoNumbers(lottoNumbers), new LottoResult());
    }

    private void createLotto(LottoNumbers lottoNumbers, LottoResult lottoResult) {
        this.lottoNumbers = lottoNumbers;
        this.lottoResult = lottoResult;
    }

    public String toStringLottoNumbers() {
        return lottoNumbers.toStringLottoNumbers();
    }

    public int getMatchCount() {
        return this.lottoResult.getMatchCount();
    }

    public boolean getIsBonusMatch() {
        return this.lottoResult.getIsBonusMatch();
    }

    public int calculateMatchCount(WinningLotto winningLotto) {
        return this.lottoResult.calculateMatchCount(winningLotto, lottoNumbers.getValues());
    }

    public int getAmount() {
        return this.lottoResult.getAmountForWinningLotto();
    }
}
