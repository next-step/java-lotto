package lotto;

import lotto.constant.LottoRank;
import lotto.model.LottoTicketList;
import lotto.model.WinningInfo;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Map;

public class LottoGame {

    private static int LOTTO_PRICE = 1000;

    public void exec() {
        int money = InputView.receiveInputMoney();
        WinningInfo winningInfo = InputView.receiveInputWinningInfo();

        int lottoCount = getLottoCount(money);
        LottoTicketList lottoTicketList = new LottoTicketList(LottoTicketMaker.issueLottoList(lottoCount));
        ResultView.printLottos(lottoCount, lottoTicketList.getLottoTickets());

        Map<LottoRank, Integer> result = lottoTicketList.scratchLottoList(winningInfo);
        double rateReturn = getRateReturn(result, money);
        ResultView.printResult(result, rateReturn);
    }

    public double getRateReturn(Map<LottoRank, Integer> gameResult, double cost) {

        double totalPrize = 0;
        for (LottoRank lottoRank : gameResult.keySet()) {
            totalPrize += lottoRank.getPrize() * gameResult.get(lottoRank);
        }
        return totalPrize / cost;
    }

    public static int getLottoCount(int money) {
        if (money < 0) {
            return 0;
        }
        return money / LOTTO_PRICE;
    }
}
