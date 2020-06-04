package lotto;

import lotto.domain.LottoBill;
import lotto.domain.LottoMachine;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoWinningNumber;
import lotto.domain.vo.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMoney lottoMoney = InputView.inputPurchaseAmount();

        OutputView.printNumberOfTicket(lottoMoney);

        LottoBill lottoBill = LottoMachine.purchaseLottoTicket(lottoMoney);

        OutputView.printLottoTickets(lottoBill.getAllTickets());

        List<Integer> winningNumbers = InputView.inputLastWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoBill.drawAllLotto(lottoWinningNumber);

        OutputView.printWinningStatistics(lottoResult, lottoMoney);
    }
}
