package lotto;

import java.util.*;

public class Lotto {

    private LottoNumbers lottoNumbers;
    private LottoResult lottoResult;

    public Lotto() {
        createLotto(new LottoNumbers(), new LottoResult());
    }

    public Lotto(List<Integer> lottoNumbers) {
        createLotto(new LottoNumbers(lottoNumbers), new LottoResult());
    }


    public Lotto(List<Integer> lottoNumbers, int bonusNumber) {
        createLotto(new LottoNumbers(lottoNumbers), new LottoResult());
        this.hasLottoNumber(bonusNumber);
    }

    private void createLotto(LottoNumbers lottoNumbers, LottoResult lottoResult) {
        this.lottoNumbers = lottoNumbers;
        this.lottoResult = lottoResult;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumbers();
    }

    public int getMatchCount() {
        return this.lottoResult.getMatchCount();
    }

    public boolean getIsBonusMatch() {
        return this.lottoResult.getIsBonusMatch();
    }

    public String toStringLottoNumbers() {
        return lottoNumbers.toStringLottoNumbers();
    }

    public int calculateMatchCount(Lotto winningLotto, int bonusNumber) {
        return this.lottoResult.calculateMatchCount(winningLotto.getLottoNumbers(), lottoNumbers.getLottoNumbers(), bonusNumber);
    }

    public int getAmount() {
        return this.lottoResult.getAmountForWinningLotto();
    }

    public boolean hasLottoNumber(int lottoNumber){
        return this.lottoNumbers.hasLottoNumber(lottoNumber);
    }
}
