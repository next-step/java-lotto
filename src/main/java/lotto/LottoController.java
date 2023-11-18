package lotto;

import java.util.List;

import static lotto.domain.Lotto.execute;
import static lotto.view.InputView.inputPurchaseValue;
import static lotto.view.ResultView.printResultLottoTicketValue;
import static lotto.view.ResultView.printResultPurchaseValue;

public class LottoController {
    public static void main(String[] args) {
        int buyCount = inputPurchaseValue();
        printResultPurchaseValue(buyCount);

        List<Integer> value = execute(buyCount);
        printResultLottoTicketValue(value);

    }
}
