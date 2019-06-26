package lotto;

import lotto.model.Lotto;
import lotto.util.LottoTicketBox;

import java.util.List;

import static lotto.io.InputView.InputPurchaseAmount;
import static lotto.io.InputView.inputWinnerNumber;
import static lotto.io.OutputView.viewLotto;

public class Main {

    public static void main(String[] args) {
        List<Lotto> lottos = LottoTicketBox.buy(InputPurchaseAmount());
        viewLotto(lottos);
        inputWinnerNumber();
    }
}
