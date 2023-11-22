package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private final LottoList lottoList;

    public LottoResult(LottoList lottoList) {
        checkLottoListSizeIsValid(lottoList);
        this.lottoList = lottoList;
    }

    private void checkLottoListSizeIsValid(LottoList lottoList) {
        if (lottoList == null || lottoList.size() == 0) {
            throw new IllegalArgumentException("최소 1개 이상의 로또 번호가 존재해야 합니다");
        }
    }

    public LottoMatchResult matchesWinningNumbers(LottoWinningNumbers lottoWinningNumbers) {
        List<LottoMatch> lottoMatches = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            LottoMatch lottoMatch = lottoWinningNumbers.matchesLotto(lotto);
            lottoMatches.add(lottoMatch);
        }

        return new LottoMatchResult(lottoMatches);
    }

    public double rateOfReturn(LottoWinningNumbers lottoWinningNumbers) {
        int purchaseAmount = lottoList.size() * LOTTO_PRICE;
        double winningAmount = 0;
        for (Lotto lotto : lottoList) {
            winningAmount += lottoWinningNumbers.amount(lotto);
        }

        return winningAmount / purchaseAmount * 1001;
    }
}
