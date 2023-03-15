package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import lotto.view.LottoConsoleView;

import java.util.Arrays;

public class LottoMain {

    public static void main(String[] args) {

        LottoConsoleView lottoConsoleView = new LottoConsoleView();

        int buyPrice = lottoConsoleView.inputLottoPrice();

        LottoMachine lottoMachine = new LottoMachine(buyPrice);

        int lottoCount = lottoMachine.lottoCount();

        lottoConsoleView.showLottoCount(lottoCount);

        lottoMachine.getLottoTickets().stream()
                .forEach(lottoTicket -> lottoConsoleView.showLottoNumber(lottoTicket.getLottoNumbers()));

        System.out.println();

        winnerLottoConsoleview(lottoConsoleView, lottoMachine);

        statisticsConsoleview(lottoConsoleView, lottoMachine);
    }

    private static void winnerLottoConsoleview(LottoConsoleView lottoConsoleView, LottoMachine lottoMachine) {
        String winningNumber = lottoConsoleView.inputWinningNumber();
        int bonusNumber = lottoConsoleView.inputBonusNumber();

        lottoMachine.saveWinningNumber(new WinningLottoTicket(new LottoTicket(winningNumber), bonusNumber));
    }

    private static void statisticsConsoleview(LottoConsoleView lottoConsoleView, LottoMachine lottoMachine) {
        lottoConsoleView.showBeforeStatistics();

        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NOTTING_PLACE)
                .forEach(
                        lottoRank -> lottoConsoleView.showMatch(lottoRank, lottoMachine.lottoRankMatchCount(lottoRank))
                );

        lottoConsoleView.showTotol(lottoMachine.getAggregationOfReturns());
    }

}
