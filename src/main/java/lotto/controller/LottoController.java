package lotto.controller;

import calculator.domain.Operator;
import lotto.domain.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final static int LOTTO_PRICE = 1000;

    public void lottoMachine() {
        Input input = new Input();
        UserInput userInput = new UserInput(input.inputPrice());
        int countOfLotto = Operator.DIVIDE.execute(userInput.getInputPrice(), LOTTO_PRICE);
        System.out.println(countOfLotto + "개를 구매했습니다");

        List<Set> lottoTickets = new Lotto().lotto(countOfLotto);
        new Output().printLottoTickets(lottoTickets);
    }
}
