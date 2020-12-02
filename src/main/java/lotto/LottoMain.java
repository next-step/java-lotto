package lotto;

import lotto.sevice.LottoOperator;
import lotto.sevice.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoOperator lotto = new LottoOperator(new InputView(), new ResultView());
        lotto.operator();
    }
    
}
