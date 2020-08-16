package lotto;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class lottoController {

    public static void main(String[] args) {
        LottoMoney lottoMoney = LottoMoney.of(InputView.scanLottoMoney());

        LottoTickets lottoTickets = LottoTickets.of(lottoMoney.getBuyCount());
        OutputView.printLottoTickets(lottoTickets);

    }
}
