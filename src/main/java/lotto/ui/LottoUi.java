package lotto.ui;

import lotto.controller.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.Statistics;
import lotto.ui.view.InputView;
import lotto.ui.view.OutputView;
import lotto.utils.IntegerParser;

public class LottoUi {

    public static void main(String[] args) {
        int won = InputView.getWon();
        LottoTicket lottoTicket = LottoMachine.publish(won);
        OutputView.showTicket(lottoTicket);

        String winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        Statistics statistics = lottoTicket.rank(toLottoNumbers(winningNumbers), toLottoNumber(bonusNumber));
        OutputView.showStatistics(statistics);
    }

    private static LottoNumbers toLottoNumbers(String winningNumbers) {
        return LottoNumbers.of(IntegerParser.listOf(winningNumbers));
    }

    private static LottoNumber toLottoNumber(int bonusNumber) {
        return LottoNumber.from(bonusNumber);
    }


}
