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

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers.getValues();
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

    public int calculateMatchCount(Lotto winningLotto, LottoNumber bonusNumber) {
        return this.lottoResult.calculateMatchCount2(winningLotto.getLottoNumbers(), lottoNumbers.getValues(), bonusNumber);
    }

    public int getAmount() {
        return this.lottoResult.getAmountForWinningLotto();
    }

    public boolean hasLottoNumber(int lottoNumber){ //todo
        return this.lottoNumbers.hasLottoNumber(lottoNumber);
    }

//    public boolean hasLottoNumber(LottoNumber lottoNumber){
//        return this.lottoNumbers.hasLottoNumber(lottoNumber);
//    }

}
