package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.dto.MyLottosResponse;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        Money money = new Money(inputMoney);

        OutputView.outputPurchaseCount(money.purchaseCount());

        MyLottos myLottos = LottoFactory.buy(money);
        OutputView.outputMyLottos(MyLottosResponse.from(myLottos));


        List<Integer> integers = InputView.winningNumbers();
        System.out.println(integers);
    }

}
