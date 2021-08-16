package lotto.controller;

import java.util.List;
import java.util.stream.Stream;

import lotto.controller.generator.AutoLottoTicketGenerator;
import lotto.controller.generator.LottoTicketGenerator;
import lotto.controller.generator.ManualLottoTicketGenerator;
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
        LottoTickets lottoTickets = LottoTickets.from(getLottoTickets(inputView, resultView, lottoCount));
        WinStatistics winStatistics = lottoController.proceedStatistics(inputView, lottoTickets);

        resultView.outputStatistics(winStatistics, winStatistics.getRateOfReturn());
        inputView.scannerClose();
    }

    private static List<LottoTicket> getLottoTickets(InputView inputView, ResultView resultView, int lottoCount) {
        int manualLottoCount = inputView.inputManualLottoTicketCount();

        List<LottoTicket> manualLottoTickets = LottoTicketGenerator.createLottoTickets(new ManualLottoTicketGenerator(),
            manualLottoCount);
        List<LottoTicket> autoLottoTickets = LottoTicketGenerator.createLottoTickets(new AutoLottoTicketGenerator(),
            lottoCount - manualLottoCount);
        manualLottoTickets.addAll(autoLottoTickets);

        resultView.outputLottoLotteries(manualLottoTickets, autoLottoTickets);

        return manualLottoTickets;
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
