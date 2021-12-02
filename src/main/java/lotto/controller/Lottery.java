package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lottery {

    private InputView inputView;
    private ResultView resultView;

    public Lottery() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void draw() {
        String price = inputView.questionPrice();

        InputInfo inputInfo = new InputInfo(price);
        int ticketCount = inputInfo.getTicketCount();
        Lottos lottos = new Lottos(ticketCount);

        resultView.printLottos(lottos);

        winner(inputInfo);
    }

    private void winner(InputInfo inputInfo) {
        String answerText = inputView.questionAnswer();
        List<Integer> answerList = inputInfo.getAnswer(answerText);
        Lotto answer = new Lotto(answerList);
    }

}
