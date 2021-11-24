package step2;

import step2.controller.LottoMachine;
import step2.domain.Lottos;
import step2.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        //input cash
        int price = InputView.inputCash();
        LottoMachine lottoMachine = LottoMachine.create(price);
        System.out.println();

        int manualLottoCount = InputView.inputManualLottoCount();
        System.out.println();

        //purchase lotto
        Lottos purchasedLottos = lottoMachine.purchase(manualLottoCount);

        //input last week lotto number
        String winningNumbers = InputView.inputLastWeekLottoNumber();
        int bonusNumber = InputView.inputBonusNumber();
        lottoMachine.winningResult(purchasedLottos, winningNumbers, bonusNumber);
    }
}
