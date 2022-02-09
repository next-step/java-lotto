package lotto;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.service.LottoMachine;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int purchasePrice = InputView.getPurchasePrice();
        final int quantity = LottoGenerator.getLottoQuantity(purchasePrice);
        final List<LottoTicket> lottoNumbers = LottoGenerator.getTotalLottoNumbers(quantity);

        ResultView.printLottoQuantity(quantity);
        ResultView.printTotalLottoNumbers(lottoNumbers);

        List<WinningNumber> winningNumbers = InputView.getWinningNumbers();
        LottoMachine.run(lottoNumbers, winningNumbers);

        ResultView.printResult(LottoMachine.getResults(), purchasePrice);
    }
}
