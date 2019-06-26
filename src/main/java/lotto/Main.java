package lotto;

import lotto.io.InputView;
import lotto.model.Lotto;
import lotto.util.LottoTicketBox;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Lotto> lottos = LottoTicketBox.buy(InputView.InputPurchaseAmount());
    }
}
