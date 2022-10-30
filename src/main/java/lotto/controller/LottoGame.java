package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
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
        Money paidMoney = input.paidMoney();
        output.showResult(Result.of(buyNumbers(method, paidMoney), lastLuckyNumber(), bonusNumber(), paidMoney));
    }

    private LottoNumbers buyNumbers(NumberGenerateStrategy method, Money paidMoney) {
        LottoNumbers numbers = LottoNumbers.of(method, paidMoney.lottoCount(price));
        output.showPurchase(numbers);
        return numbers;
    }
    
    private LottoNumber lastLuckyNumber() {
        return input.lastLuckyNumber();
    }
    
    private int bonusNumber() {
        return input.bonusNumber();
    }
}

