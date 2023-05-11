package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoUtils;
import lotto.util.RewardTable;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
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
        int noAutoLottoCount = Integer.parseInt(inputView.setNoAutoBuyLottoCount());
        List<String> noAutoLottoNumbers = inputView.setNoAutoLottoNumbers(noAutoLottoCount);

        int lottoGameCount = LottoUtils.getLottoGameCount(lottoBuyPrice);

        List<LottoTicket> noAutoLottoTickets = new ArrayList<>();
        for(String numbers : noAutoLottoNumbers) {
            noAutoLottoTickets.add(new LottoTicket(LottoUtils.lottoResultNumberList(numbers)));
        }

        Lottos lottos = new Lottos(noAutoLottoTickets,lottoGameCount - noAutoLottoCount);

        resultView.showBuyLotto(noAutoLottoCount, lottoGameCount - noAutoLottoCount);
        resultView.showMyLottoGameList(lottos.getTickets());

        List<Integer> lottoResultNumbers = LottoUtils.lottoResultNumberList(inputView.setLottoResultNumber());

        int lottoBonusNumber = inputView.setLottoBonusNumber();
        while(lottoResultNumbers.contains(lottoBonusNumber)){
            lottoBonusNumber = inputView.setLottoBonusNumber();
        }

        WinningStatistics winningStatistics = new WinningStatistics(lottoResultNumbers, lottoBonusNumber);

        Map<RewardTable, Long> resultGameStatistics = winningStatistics.resultLottoGame(lottos.getTickets());

        Reward reward = new Reward();
        Long totalMatchPrice = reward.sumTotalMatchPrice(resultGameStatistics);
        double rateOfReturn = LottoUtils.calRateOfReturn(totalMatchPrice, lottoBuyPrice);

        resultView.resultGame(resultGameStatistics, rateOfReturn);
    }
}
