package lotto.services;

import lotto.domains.Lotto;
import lotto.domains.LottoResults;
import lotto.domains.Lottos;
import lotto.domains.WinningNumber;
import utils.DataParser;

public class LottoShop {

    private final WinningNumber winningNumber;
    private final LottoResults lottoResults;

    public LottoShop(String lastWeekWinningNumberString) {
        this.winningNumber = new WinningNumber(lastWeekWinningNumberString);
        this.lottoResults = new LottoResults();
    }

    public LottoResults winner(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            lottoResults.addWinner(winningNumber.numOfWinningNumberMatchCnt(lotto));
        }

        return lottoResults;
    }

    public Double profitRate(String moneyString) {
        int money = DataParser.parseToInt(moneyString);
        return lottoResults.profitRate(money);
    }
}
