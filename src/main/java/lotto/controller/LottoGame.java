package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.Result;
import lotto.domain.strategy.NumberGenerateStrategy;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGame {
    private final ConsoleInputView input;
    private final ConsoleOutputView output;
    private final Money price;

    public LottoGame(ConsoleInputView input, ConsoleOutputView output, Money price) {
        this.input = input;
        this.output = output;
        this.price = price;
    }

    public void start(NumberGenerateStrategy method) {
        output.showResult(Result.of(buyNumbers(method), lastLuckyNumber()));
    }

    private LottoNumbers buyNumbers(NumberGenerateStrategy method) {
        LottoNumbers numbers = LottoNumbers.of(method, input.paidMoney().lottoCount(price));
        output.showPurchase(numbers);
        return numbers;
    }
    
    private Number lastLuckyNumber() {
        Number luckyNumber = input.lastLuckyNumber();
        output.showNumber(luckyNumber);
        return luckyNumber;
    }
}

