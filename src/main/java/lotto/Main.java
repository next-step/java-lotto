package lotto;

import lotto.domain.lotto.*;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int inputPrice = InputView.printRequirePrice();
        Price price = new Price(inputPrice);

        int manualLottoCount = InputView.printRequireManualLottoCount();
        List<String> manualLottoNumbers = InputView.printRequireManualLottoNumbers(manualLottoCount);

        LottoMachine lottoMachine = new LottoMachine(price, manualLottoNumbers);

        OutputView.printPurchasedLottoCount(manualLottoCount, lottoMachine.getLottoTicket());
        OutputView.printPurchasedLottoTicket(lottoMachine.getLottoTicket());

        String winningNumbers = InputView.printRequireWinningNumbers();
        int bonusNumber = InputView.printRequireBonusBall();

        OutputView.printStatistics(new WinningStatistics(price, lottoMachine.match(winningNumbers, bonusNumber)));
    }
}
