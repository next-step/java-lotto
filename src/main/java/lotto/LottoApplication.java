package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashSet;
import java.util.Set;

public class LottoApplication {
    public static void main(String args[]) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int lottoCount = lottoMachine.getPurchaseLottoCount();
        ResultView.countOfLotto(lottoCount);

        Set<LottoTicket> totalLottoTickets = new HashSet<>();

        for (int i = 0; i < lottoMachine.getPurchaseLottoCount(); i++) {
            LottoTicket generateLottoTicket = lottoMachine.generateLottoNumber();
            ResultView.printLottoNumber(generateLottoTicket);
            totalLottoTickets.add(generateLottoTicket);
        }

        LottoTickets collectionOflLottoNumbers = LottoTickets.of(totalLottoTickets);

        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(InputView.getWinningNumber());

        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.getBonusNumber());

        LottoResult lottoResult = LottoResult.of(collectionOflLottoNumbers, winningLottoTicket, bonusLottoNumber);

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount));

    }
}
