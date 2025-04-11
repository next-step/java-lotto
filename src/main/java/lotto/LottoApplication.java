package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        Money price = InputView.getPurchasePrice();
        TicketAmount manualLottoAmount = InputView.getManualLottoAmount();
        List<LottoTicket> manualLotto = InputView.getManualLottoNumbers(manualLottoAmount);
        List<LottoTicket> totalLotto = lottoShop.sellLotto(price, manualLotto);

        ResultView.printLottoTicketAmount(manualLotto.size(), totalLotto.size() - manualLotto.size());
        totalLotto.forEach(ResultView::printLottoNumbers);

        LottoTicket winningNumbers = InputView.getWinningLotto();
        LottoNumber bonusNumber = InputView.getBonusNumber();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        LottoEarning lottoEarning = LottoEarning.from(winningLottoNumbers.calculateResult(totalLotto), price.getPrice());
        ResultView.printMatchResult(lottoEarning.getResult());
        ResultView.printReturnRate(lottoEarning.getReturnRate());
    }
}
