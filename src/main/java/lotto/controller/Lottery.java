package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.lotto.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Lottery {

    public void draw() {
        String price = InputView.questionPrice();

        Lottos lottos = new Lottos(price);

        ResultView.printLottos(lottos);

        winner(lottos);
    }

    private void winner(Lottos lottos) {
        String answerText = InputView.questionAnswer();
        String bonusBall = InputView.questionBonus();
        Number bonus = new Number(bonusBall);
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto answer = factory.newInstance(answerText);
        ResultView resultView = new ResultView(lottos, answer, bonus);
        resultView.printResult();
    }

}
