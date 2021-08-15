package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<LottoTicket> lottoTicketList = lottoController.createLottoBalls(inputView, resultView, lottoCount);
        LottoTickets lottoTickets = LottoTickets.from(lottoTicketList);

        WinStatistics winStatistics = lottoController.proceedStatistics(inputView, lottoTickets);
        resultView.outputStatistics(winStatistics, winStatistics.getRateOfReturn(lottoCount));
        inputView.scannerClose();
    }

    public List<LottoTicket> createLottoBalls(InputView inputView, ResultView resultView, int lottoCount) {
        int manualLottoTicketCount = inputView.inputManualLottoTicketCount();
        int autoLottoTicketCount = lottoCount - manualLottoTicketCount;

        List<LottoTicket> manualLottoTickets = getManualLottoTickets(inputView, manualLottoTicketCount);
        List<LottoTicket> autoLottoTickets = getAutoLottoTickets(autoLottoTicketCount);

        resultView.outputLottoLotteries(manualLottoTickets, autoLottoTickets);
        manualLottoTickets.addAll(autoLottoTickets);
        return manualLottoTickets;
    }

    private List<LottoTicket> getManualLottoTickets(InputView inputView, int manualLottoTicketCount) {
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        List<String> manualLottoTicketsList = inputView.inputManualLottoTickets(manualLottoTicketCount);
        for (int i = 0; i < manualLottoTicketCount; i++) {
            String[] lottoTicketStringArray = manualLottoTicketsList.get(i).split(",");
            int[] lottoTicketIntArray = Arrays.stream(lottoTicketStringArray).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
            manualLottoTickets.add(LottoTicket.of(lottoTicketIntArray));
        }
        return manualLottoTickets;
    }

    private List<LottoTicket> getAutoLottoTickets(int autoLottoTicketCount) {
        List<LottoTicket> autoLottoTickets = new ArrayList<>();
        for (int i = 0; i < autoLottoTicketCount; i++) {
            autoLottoTickets.add(LottoTicket.createRandomNumber());
        }
        return autoLottoTickets;
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
