package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNoPool;
import lotto.domain.Money;
import lotto.domain.WinningCondition;
import lotto.dto.PurchaseMoneyDto;
import lotto.dto.WinningConditionDto;
import lotto.view.InputView;

class InputAdapter {
    private InputAdapter() {}

    static Money getPurchaseMoney() {
        PurchaseMoneyDto dto = InputView.getPurchaseMoneyDto();
        return new Money(dto.getPurchaseMoney());
    }

    static WinningCondition getWinningCondition() {
        WinningConditionDto dto = InputView.getWinningConditionDto();
        return new WinningCondition(
                parseLotto(dto.getWinningLotto()),
                LottoNoPool.getLottoNo(dto.getBonus())
        );
    }

    private static Lotto parseLotto(String lotto) {
        String splitRegex = "[ ,]+";
        return new Lotto(Splitter.splitIntegers(lotto, splitRegex));
    }
}
