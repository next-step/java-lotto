package lotto;

import lotto.domain.*;
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

        int lottoCount = lottoMachine.getPurchaseLottoCount();
        ResultView.countOfLotto(lottoCount);

        List<LottoTicket> totalLottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoMachine.getPurchaseLottoCount(); i++) {
            LottoTicket generateLottoTicket = lottoMachine.generateLottoNumber();
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
