package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoUtils;
import lotto.util.RewardTable;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoController {

    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        lotto();
    }

    public static void lotto() {

        int lottoBuyPrice = Integer.parseInt(inputView.setBuyLottoPrice());
        int lottoGameCount = LottoUtils.getLottoGameCount(lottoBuyPrice);

        Lottos lottos = new Lottos(lottoGameCount);

        resultView.showBuyLotto(lottoGameCount);
        resultView.showMyLottoGameList(lottos.getTickets());

        List<Integer> lottoResultNumbers = LottoUtils.lottoResultNumberList(inputView.setLottoResultNumber());

        int lottoBonusNumber = inputView.setLottoBonusNumber();
        while(lottoResultNumbers.contains(lottoBonusNumber)){
            lottoBonusNumber = inputView.setLottoBonusNumber();
        }

        WinningStatistics winningStatistics = new WinningStatistics(lottoResultNumbers, lottoBonusNumber);

        Map<RewardTable, Integer> resultGameStatistics = winningStatistics.resultLottoGame(lottos.getTickets());

        Reward reward = new Reward();
        int totalMatchPrice = reward.sumTotalMatchPrice(resultGameStatistics);
        double rateOfReturn = LottoUtils.calRateOfReturn(totalMatchPrice, lottoBuyPrice);

        resultView.resultGame(resultGameStatistics, rateOfReturn);
    }
}
