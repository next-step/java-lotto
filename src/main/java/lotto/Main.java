package lotto;

import static lotto.domain.strategy.NumberGenerateStrategy.*;

import lotto.controller.LottoGame;
import lotto.domain.Money;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Main {
    public static void main(String[] args) {
        new LottoGame(new ConsoleInputView(), new ConsoleOutputView(), new Money(1000)).start(RANDOM);
    }
}
