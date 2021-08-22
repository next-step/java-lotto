package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoMachine;
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
        LottoTickets lottoTickets = LottoTickets.from(lottoController.getLottoTickets(inputView, resultView, lottoCount));
        WinStatistics winStatistics = lottoController.proceedStatistics(inputView, lottoTickets);

        resultView.outputStatistics(winStatistics, winStatistics.getRateOfReturn());
        inputView.scannerClose();
    }

    private List<LottoTicket> getLottoTickets(InputView inputView, ResultView resultView, int lottoCount) {
        int manualLottoCount = inputView.inputManualLottoTicketCount();

        LottoMachine lottoMachine = new LottoMachine();
        resultView.outputManualLottoTickets(manualLottoCount);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            int[] lottoTicketNumbers = inputView.inputManualLottoTickets().stream().mapToInt(Integer::intValue).toArray();
            lottoTickets.add(lottoMachine.manualCreate(lottoTicketNumbers));
        }
        lottoTickets.addAll(lottoMachine.autoCreate(lottoCount - manualLottoCount));
        resultView.outputLottoLotteries(lottoTickets, manualLottoCount);

        return lottoTickets;
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
