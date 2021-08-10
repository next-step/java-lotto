package lotto.domain;

import java.util.*;

public class Lotto {
    private final LottoNumber lottoNumber;
    private Rank lottoRank;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber.getLottoNumber();
    }

    public void matchLottoRank(WinningNumbers winningNumber) {
        lottoRank = lottoNumber.getRank(winningNumber);
    }

    public Rank getRank() {
        return lottoRank;
    }
}
