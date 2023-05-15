package lotto.controller;

import lotto.domain.*;
import lotto.util.*;
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
        int manualLottoCount = Integer.parseInt(inputView.setNoAutoBuyLottoCount());

        List<LottoTicket> manualTickets = new ArrayList<>();
        if(manualLottoCount != 0) {
            List<String> manualLottoNumbers = inputView.setNoAutoLottoNumbers(manualLottoCount);

            for (String numbers : manualLottoNumbers) {
                manualTickets.add(new LottoTicket(LottoGenerate.initLottoNumbers(numbers)));
            }
        }

        int lottoGameCount = LottoUtils.getLottoGameCount(lottoBuyPrice);

        Lottos lottos = new Lottos(LottoShop.sell((lottoGameCount - manualLottoCount), manualTickets));

        resultView.showBuyLotto(manualLottoCount, lottoGameCount - manualLottoCount);
        resultView.showMyLottoGameList(lottos.getTickets());

        List<LottoNumber> lottoResultNumbers = LottoGenerate.initLottoNumbers(inputView.setLottoResultNumber());

        int lottoBonusNumber = inputView.setLottoBonusNumber();
        while(lottoResultNumbers.contains(lottoBonusNumber)){
            lottoBonusNumber = inputView.setLottoBonusNumber();
        }

        WinningStatistics winningStatistics = new WinningStatistics(lottoResultNumbers, new LottoNumber(lottoBonusNumber));

        Map<RewardTable, Long> resultGameStatistics = winningStatistics.resultLottoGame(lottos.getTickets());

        Reward reward = new Reward();
        Long totalMatchPrice = reward.sumTotalMatchPrice(resultGameStatistics);
        double rateOfReturn = LottoUtils.calRateOfReturn(totalMatchPrice, lottoBuyPrice);

        resultView.resultGame(resultGameStatistics, rateOfReturn);
    }
}
