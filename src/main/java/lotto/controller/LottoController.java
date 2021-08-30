package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController();

        int lottoCount = inputView.inputLottoBuyAmount() / 1000;
        LottoTickets lottoTickets = lottoController.getLottoTickets(inputView, resultView, lottoCount);
        WinStatistics winStatistics = lottoController.proceedStatistics(inputView, lottoTickets);

        resultView.outputStatistics(winStatistics, winStatistics.getRateOfReturn());
        inputView.scannerClose();
    }

    private LottoTickets getLottoTickets(InputView inputView, ResultView resultView, int lottoCount) {
        int manualLottoCount = inputView.inputManualLottoTicketCount();
        resultView.outputManualLottoTickets(manualLottoCount);

        LottoMachine lottoMachine = new LottoMachine();
        List<LottoTicket> tickets = new ArrayList<>();
        IntStream.range(0, manualLottoCount).forEach(i -> tickets.add(lottoMachine.manualCreate(inputView.inputManualLottoTickets())));

        return lottoMachine.oneTimeCreate(LottoTickets.from(tickets), lottoCount - manualLottoCount);
    }

    public WinStatistics proceedStatistics(InputView inputView, LottoTickets lottoTickets) {
        LottoTicket lottoTicket =
            LottoTicket.of(Stream.of(inputView.inputLastWeekWinnerNumbers().split(","))
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray());
        WinnerNumbers winnerNumbers = WinnerNumbers.from(lottoTicket, LottoBall.select(inputView.inputBonusNumber()));
        return lottoTickets.calculateStatistics(winnerNumbers);
    }
}
