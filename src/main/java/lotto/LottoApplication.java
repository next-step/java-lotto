package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Money price = InputView.getPurchasePrice();
        TicketAmount manualLottoAmount = InputView.getManualLottoAmount();
        TicketAmount totalLottoAmount = LottoShop.validateAndGetTotalTicketAmount(price, manualLottoAmount);
        List<LottoTicket> manualLotto = InputView.getManualLottoNumbers(manualLottoAmount);

        LottoShop lottoShop = new LottoShop(price, totalLottoAmount, manualLottoAmount, manualLotto);
        ResultView.printLottoTicketAmount(lottoShop.getManualTicketAmount(), lottoShop.getAutoTicketAmount());
        lottoShop.getLottoTicketsNumber().forEach(ResultView::printLottoNumbers);

        LottoTicket winningNumbers = InputView.getWinningLotto();
        LottoNumber bonusNumber = InputView.getBonusNumber();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        LottoEarning lottoEarning = LottoEarning.from(winningLottoNumbers.calculateResult(lottoShop.getLottoTicketsNumber()), lottoShop.getPurchasePrice());
        ResultView.printMatchResult(lottoEarning.getResult());
        ResultView.printReturnRate(lottoEarning.getReturnRate());
    }
}
