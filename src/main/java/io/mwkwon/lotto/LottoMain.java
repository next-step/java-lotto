package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.LottoMachine;
import io.mwkwon.lotto.view.LottoInputView;
import io.mwkwon.lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        new LottoApplication(new LottoInputView(), new ResultView(), new LottoMachine()).run();
    }
}
