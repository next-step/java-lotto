package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.factory.LottoAnswerFactory;
import lotto.domain.lotto.Lotto;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lottery {

    public void draw() {
        String price = InputView.questionPrice();

        InputInfo inputInfo = new InputInfo(price);
        Lottos lottos = new Lottos(price);

        ResultView.printLottos(lottos);

        winner(inputInfo, lottos);
    }

    private void winner(InputInfo inputInfo, Lottos lottos) {
        String answerText = InputView.questionAnswer();
        List<Integer> answerList = inputInfo.getAnswer(answerText);
        String bonusBall = InputView.questionBonus();
        Number bonus = new Number(bonusBall);
        LottoAnswerFactory factory = new LottoAnswerFactory();
        Lotto answer = factory.newInstance(answerList);
        ResultView resultView = new ResultView(lottos, answer, bonus);
        resultView.printResult();
    }

}
