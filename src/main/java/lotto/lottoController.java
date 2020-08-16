package lotto;

import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class lottoController {

    public static void main(String[] args) {
        LottoMoney lottoMoney = LottoMoney.of(InputView.scanLottoMoney());
    }
}
