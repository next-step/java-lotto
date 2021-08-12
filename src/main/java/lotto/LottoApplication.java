package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String args[]) {
        LottoPrice lottoPrice = LottoPrice.of(InputView.getPurchaseAmount());

        int manualLottoCount = InputView.getManualLottoTicketCount();
        lottoPrice.checkOverPrice(manualLottoCount);

        List<LottoTicket> totalLottoTickets = new ArrayList<>();
        InputView.manualLottoNumberQuestion();

        LottoTicketGenerator lottoTicketGenerator;
        for (int i = 0; i < manualLottoCount; i++) {
            lottoTicketGenerator = new ManualLottoTicketGenerator(InputView.getManualLottoNumber());
            totalLottoTickets.add(lottoTicketGenerator.execute());
        }

        int lottoTotalCount = lottoPrice.getMaxQuantity();
        int autoLottoCount = lottoTotalCount - manualLottoCount;
        ResultView.countOfLotto(manualLottoCount, autoLottoCount);


        lottoTicketGenerator = new AutoLottoTicketGenerator();
        for (int i = 0; i < autoLottoCount; i++) {
            LottoTicket generatedLottoTicket = lottoTicketGenerator.execute();
            totalLottoTickets.add(generatedLottoTicket);
        }

        LottoTickets lottotickets = LottoTickets.of(totalLottoTickets);

        ResultView.printLottoTickets(lottotickets);

        List<Integer> winningLottoNumbers = InputView.getWinningNumber();
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.getBonusNumber());
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(LottoTicket.of(winningLottoNumbers), bonusLottoNumber);

        LottoResult lottoResult = LottoResult.of(lottotickets, winningLottoTicket);
        ResultView.printWinningStatistics(lottoResult);
        ResultView.printProfitRate(lottoResult.calculateProfitRate(lottoPrice));

    }
}
