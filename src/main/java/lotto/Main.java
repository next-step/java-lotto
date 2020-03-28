package lotto;

import lotto.domain.LottoGroup;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();

        LottoGroup lottoGroup = lottoMachine.generateLottoGroup(inputMoney);

        ResultView.printBuyResult(lottoGroup);
    }

}
