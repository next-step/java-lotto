package step2;

import step2.controller.LottoMachine;
import step2.domain.Lottos;
import step2.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        //input cash
        int price = InputView.inputCash();

        //purchase lotto
        LottoMachine lottoMachine = LottoMachine.create(price);
        Lottos purchasedLottos = lottoMachine.purchase();

        //input last week lotto number
        String winningNumbers = InputView.inputLastWeekLottoNumber();
        lottoMachine.winningResult(purchasedLottos, winningNumbers);
    }
}
