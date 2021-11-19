package lotto.model;

import common.model.Number;

import java.util.List;

public class LottoWinner {
    private final List<LottoNumber> winnerNumbers;

    public LottoWinner(List<LottoNumber> winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public void match(LottoNumbers lottoNumbers) {
        Number matchCount = new Number();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            match(lottoNumber, matchCount);
        }
        lottoNumbers.matchRank(matchCount);
    }

    public void match(LottoNumber lottoNumber, Number matchCount) {
        if (contains(lottoNumber)) {
            matchCount.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.winnerNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getWinnerNumbers() {
        return winnerNumbers;
    }
}
