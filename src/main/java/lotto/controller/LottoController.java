package lotto.controller;

import lotto.domain.LottoBall;
import lotto.domain.LottoBalls;
import lotto.domain.LottoTickets;
import lotto.domain.WinStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController();

        int lottoCount = inputView.inputLottoBuyAmount() / 1000;
        List<LottoBalls> lottoBallsList = lottoController.createLottoBalls(resultView, lottoCount);
        LottoTickets lottoTickets = LottoTickets.from(lottoBallsList);

        WinStatistics winStatistics = lottoController.proceedStatistics(inputView, lottoTickets);
        resultView.outputStatistics(winStatistics, lottoTickets.getRateOfReturn(lottoCount, winStatistics));
        inputView.scannerClose();
    }

    public List<LottoBalls> createLottoBalls(ResultView resultView, int lottoCount) {
        List<LottoBalls> lottoBallsList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoBallsList.add(LottoBalls.createRandomNumber());
        }
        resultView.outputLottoLotteries(lottoBallsList);
        return lottoBallsList;
    }

    public WinStatistics proceedStatistics(InputView inputView, LottoTickets lottoTickets) {
        LottoBalls lottoBalls =
            LottoBalls.of(Stream.of(inputView.inputLastWeekWinnerNumbers().split(","))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray());
        return WinStatistics.from(lottoBalls, LottoBall.select(inputView.inputBonusNumber()), lottoTickets);
    }
}
