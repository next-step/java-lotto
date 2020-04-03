package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        long price = InputView.inputPrice();

        Buyer buyer = new Buyer();
        List<LottoTicket> lottoTickets = buyer.buyLottoTickets(Money.of(price));

        ResultView.printLottoTickets(lottoTickets);

        LottoNumbers winningNumbers = LottoNumbers.of(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());
        BuyerResult buyerResult = buyer.getResult(WinningLotto.of(bonusNumber, winningNumbers));

        ResultView.printWinningStatistics(buyerResult);
    }

    private static LottoTicket createLottoTicket(int[] winningNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int winningNumber : winningNumbers) {
            lottoNumbers.add(LottoNumber.of(winningNumber));
        }
        return new LottoTicket(lottoNumbers);
    }
}
