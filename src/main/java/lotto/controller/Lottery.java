package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.lotto.Lotto;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Lottery {

    public void draw() {
        Number price = Number.of(InputView.questionPrice());
        Number manualCount = Number.of(InputView.questionManualCount());

        InputInfo inputInfo = new InputInfo(price, manualCount);

        Lottos lottos = new Lottos();

        ResultView.printLottos(lottos);

        winner(lottos);
    }

    private void winner(Lottos lottos) {
        String answerText = InputView.questionAnswer();
        String bonusBall = InputView.questionBonus();
        Number bonus = Number.of(bonusBall);
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto answer = factory.newInstance(answerText);
        ResultView resultView = new ResultView(lottos, answer, bonus);
        resultView.printResult();
    }

}
