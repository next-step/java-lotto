package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private final LottoList lottoList;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoGame(LottoList lottoList, LottoWinningNumbers lottoWinningNumbers) {
        validate(lottoList, lottoWinningNumbers);
        this.lottoList = lottoList;
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public void validate(LottoList lottoList, LottoWinningNumbers lottoWinningNumbers) {
        checkLottoListSizeIsValid(lottoList);
        checkLottoWinningNumbersIsValid(lottoWinningNumbers);
    }

    private void checkLottoListSizeIsValid(LottoList lottoList) {
        if (lottoList == null || lottoList.size() == 0) {
            throw new IllegalArgumentException("최소 1개 이상의 로또 번호가 존재해야 합니다");
        }
    }

    private void checkLottoWinningNumbersIsValid(LottoWinningNumbers lottoWinningNumbers) {
        if (lottoWinningNumbers == null) {
            throw new IllegalArgumentException("로또 당첨번호가 존재해야 합니다");
        }
    }

    public LottoResult start() {
        double rateOfReturn = rateOfReturn();
        LottoMatchResult lottoMatchResult = matchesWinningNumbers();

        return new LottoResult(rateOfReturn, lottoMatchResult);
    }

    public LottoMatchResult matchesWinningNumbers() {
        List<LottoMatch> lottoMatches = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            LottoMatch lottoMatch = lottoWinningNumbers.matchesLotto(lotto);
            lottoMatches.add(lottoMatch);
        }

        return new LottoMatchResult(lottoMatches);
    }

    public double rateOfReturn() {
        int purchaseAmount = lottoList.size() * LOTTO_PRICE;
        double winningAmount = 0;
        for (Lotto lotto : lottoList) {
            winningAmount += lottoWinningNumbers.amount(lotto);
        }

        return winningAmount / purchaseAmount * 100;
    }
}
