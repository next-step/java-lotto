package lotto;

import lotto.domain.*;
import lotto.utils.AutoLottoTicketGenerator;
import lotto.utils.LottoTicketGenerator;
import lotto.utils.ManualLottoTicketGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int manualLottoCount = InputView.getManualLottoTicketCount();
        lottoMachine.checkValidManualCount(manualLottoCount);

        List<LottoTicket> totalLottoTickets = new ArrayList<>();
        InputView.manualLottoNumberQuestion();

        LottoTicketGenerator lottoTicketGenerator = new ManualLottoTicketGenerator();
        for (int i = 0; i < manualLottoCount; i++) {
            totalLottoTickets.add(lottoTicketGenerator.execute());
        }

        int lottoTotalCount = lottoMachine.getPurchaseLottoCount();
        int autoLottoCount = lottoTotalCount - manualLottoCount;
        ResultView.countOfLotto(manualLottoCount, autoLottoCount);


        lottoTicketGenerator = new AutoLottoTicketGenerator();
        for (int i = 0; i < autoLottoCount; i++) {
            LottoTicket generatedLottoTicket = lottoTicketGenerator.execute();
            ResultView.printLottoNumber(generatedLottoTicket);
            totalLottoTickets.add(generatedLottoTicket);
        }

        LottoTickets lottotickets = LottoTickets.of(totalLottoTickets);

        List<Integer> winningLottoNumbers = InputView.getWinningNumber();
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.getBonusNumber());
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(LottoTicket.of(winningLottoNumbers), bonusLottoNumber);

        LottoResult lottoResult = LottoResult.of(lottotickets, winningLottoTicket);
        ResultView.printWinningStatistics(lottoResult);
        ResultView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount));

    }
}
