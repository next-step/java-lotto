package lotto;

import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class lottoController {

    public static void main(String[] args) {
        String lottoMoney = InputView.scanLottoMoney();

        LottoMoney.of(lottoMoney);
    }
}
