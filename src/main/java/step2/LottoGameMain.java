package step2;

import step2.domain.LottoGame;

import java.math.BigDecimal;

import static step2.view.InputView.inputMessageLottoAmount;

public class LottoGameMain {

    public static void main(String[] args) {
        int amount = inputMessageLottoAmount();
        LottoGame lottoGame = new LottoGame(BigDecimal.valueOf(amount));
    }


}
