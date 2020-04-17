package Lotto.domain;

import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoResult getResult(final WinningLotto winningLotto) {
        final LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoList) {
            lottoResult.insertResult(lotto.getWinningTypeWithWinningNumbers(winningLotto.getWinningNumbers()));
        }
        return lottoResult;
    }
}
