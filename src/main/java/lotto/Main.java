package lotto;

import lotto.model.Lotto;

import java.util.List;

import static lotto.io.InputView.InputPurchaseAmount;
import static lotto.io.InputView.inputWinnerNumber;
import static lotto.io.OutputView.viewLotto;
import static lotto.util.LottoTicketBox.buy;

public class Main {

    public static void main(String[] args) {
        List<Lotto> lottos = buy(InputPurchaseAmount());
        viewLotto(lottos);
        inputWinnerNumber();
    }
}
