package lotto;

import lotto.domain.*;
import lotto.utils.RandomLottoTicketGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int manualLottoCount = InputView.getManualLottoTicketCount();
        lottoMachine.checkValidManualCount(manualLottoCount);

        List<LottoTicket> totalLottoTickets = new ArrayList<>();
        InputView.manualLottoNumberQuestion();
        for (int i = 0; i < manualLottoCount; i++) {
            totalLottoTickets.add(lottoMachine.generateLottoTicket(InputView.getManualLottoNumber()));
        }

        int lottoTotalCount = lottoMachine.getPurchaseLottoCount();
        int autoLottoCount = lottoTotalCount - manualLottoCount;
        ResultView.countOfLotto(manualLottoCount, autoLottoCount);


        for (int i = 0; i < autoLottoCount; i++) {
            LottoTicket generateLottoTicket = lottoMachine.generateLottoTicket(RandomLottoTicketGenerator.execute());
            ResultView.printLottoNumber(generateLottoTicket);
            totalLottoTickets.add(generateLottoTicket);
        }

        LottoTickets lottotickets = LottoTickets.of(totalLottoTickets);

        List<Integer> winningLottoNumbers = InputView.getWinningNumber();
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.getBonusNumber());
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(winningLottoNumbers, bonusLottoNumber);

        LottoResult lottoResult = LottoResult.of(lottotickets, winningLottoTicket);
        ResultView.printWinningStatistics(lottoResult);
        ResultView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount));

    }
}
