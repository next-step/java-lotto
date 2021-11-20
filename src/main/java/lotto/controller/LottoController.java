package lotto.controller;

import lotto.controller.view.InputView;
import lotto.controller.view.OutputView;
import lotto.domain.*;
import lotto.utils.IntegerParser;

import java.util.Collections;

public class LottoController {

    private LottoController() {
    }

    public static void main(String[] args) {
        LottoTicket lottoTicket = publishLottoTicket();
        OutputView.showTicket(lottoTicket);

        Statistics statistics = rank(lottoTicket);
        OutputView.showStatistics(statistics);
    }

    private static LottoTicket publishLottoTicket() {
        int won = InputView.getWon();
        return LottoTicket.publish(new Dollars(won), Collections::shuffle);
    }

    private static Statistics rank(LottoTicket lottoTicket) {
        String winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        return lottoTicket.rank(toLottoNumbers(winningNumbers), toLottoNumber(bonusNumber));
    }

    private static LottoNumbers toLottoNumbers(String winningNumbers) {
        return LottoNumbers.of(IntegerParser.listOf(winningNumbers));
    }

    private static LottoNumber toLottoNumber(int bonusNumber) {
        return LottoNumber.from(bonusNumber);
    }
}
