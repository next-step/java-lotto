package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void calculateRank(WinningNumber winningNumber, Rank rank) {
        lottoNumbers.forEach(l -> winningNumber.calculateRank(l, rank));
    }

    public int getLottoSize() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
