package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMachine {

    public static void main(String[] args) {
        LottoBundle bundle = LottoFactory.buyTickets(InputView.howMuch());
        ResultView.showTickets(bundle);

        LottoNumbers winningNumbers = new LottoNumbers(InputView.getWinningNumbers());

        LottoResult result = bundle.drawing(winningNumbers);
        ResultView.showDrawingResult(result);
    }
}
