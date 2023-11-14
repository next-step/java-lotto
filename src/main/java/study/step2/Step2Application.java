package study.step2;

import study.step2.domain.dto.PurchaseAmount;
import study.step2.view.ResultView;

import static study.step2.view.InputView.input;

public class Step2Application {

    public static void main(String[] args) {
        PurchaseAmount amount = input();
        int numberOfLottos = amount.numberOfLottos();
        ResultView.lottoCount(numberOfLottos);

    }
}
