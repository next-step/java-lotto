package lotto.domain;

import java.util.*;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    private final MatchCount matchCount;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
        this.matchCount = new MatchCount();
    }


    public Lotto(List<Integer> defaultLottoNumber) {
        this.lottoNumbers = new LottoNumbers(defaultLottoNumber);
        this.matchCount = new MatchCount();
    }

    public void compareWinningNumber(List<Integer> winningNumberList) {
        for (Integer winningNumber : winningNumberList) {
            addOriginMatchPoint(winningNumber);
        }
    }
    private void addOriginMatchPoint(int winningNumber) {
        if (lottoNumbers.isContains(winningNumber)) {
            this.matchCount.increaseOriginMatchNumber();
        }
    }

    public void addBonusMatchPoint(int bonusNumber) {
        if (lottoNumbers.isContains(bonusNumber)) {
            this.matchCount.increaseBonusMatchNumber();
        }
    }

    public int getLottoOriginMatchNumber() {
        return this.matchCount.getLottoOriginMatchNumber();
    }

    public List<Number> getLottoNumber() {
        return this.lottoNumbers.getLottoNumbers();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int getLottoBonusMatchNumber() {
        return this.matchCount.getLottoBonusMatchNumber();
    }
}
