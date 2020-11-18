package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNoPool;
import lotto.domain.Money;
import lotto.domain.WinningCondition;
import lotto.dto.input.PurchaseMoneyDto;
import lotto.dto.input.WinningConditionDto;
import lotto.view.InputView;

class InputMapper {
    private InputMapper() {}

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
        return new Lotto(Splitter.splitStringToIntegers(lotto, splitRegex));
    }
}
