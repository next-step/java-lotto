package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinStatistics;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController();

        int lottoCount = inputView.inputLottoBuyAmount() / 1000;
        List<LottoTicket> lottoTicketList = lottoController.createLottoBalls(resultView, lottoCount);
        LottoTickets lottoTickets = LottoTickets.from(lottoTicketList);

        WinStatistics winStatistics = lottoController.proceedStatistics(inputView, lottoTickets);
        resultView.outputStatistics(winStatistics, lottoTickets.getRateOfReturn(lottoCount, winStatistics));
        inputView.scannerClose();
    }

    public List<LottoTicket> createLottoBalls(ResultView resultView, int lottoCount) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTicketList.add(LottoTicket.createRandomNumber());
        }
        resultView.outputLottoLotteries(lottoTicketList);
        return lottoTicketList;
    }

    public WinStatistics proceedStatistics(InputView inputView, LottoTickets lottoTickets) {
        LottoTicket lottoTicket =
            LottoTicket.of(Stream.of(inputView.inputLastWeekWinnerNumbers().split(","))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray());
        WinnerNumbers winnerNumbers = WinnerNumbers.from(lottoTicket, LottoBall.select(inputView.inputBonusNumber()));
        return WinStatistics.from(winnerNumbers, lottoTickets);
    }
}
