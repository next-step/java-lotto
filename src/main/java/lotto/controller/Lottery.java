package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lottery {

    public void draw() {
        String price = InputView.questionPrice();

        InputInfo inputInfo = new InputInfo(price);
        int count = inputInfo.getLottoCount();
        Lottos lottos = new Lottos(count);

        ResultView.printLottos(lottos);

        winner(inputInfo, lottos);
    }

    private void winner(InputInfo inputInfo, Lottos lottos) {
        String answerText = InputView.questionAnswer();
        List<Integer> answerList = inputInfo.getAnswer(answerText);
        Lotto answer = new Lotto(answerList);
        ResultView resultView = new ResultView(lottos, answer);
        resultView.printResult();
    }

}
