package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNoPool;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningCondition;
import lotto.dto.input.PurchaseDto;
import lotto.dto.input.WinningConditionDto;
import lotto.view.InputView;

import java.util.stream.Collectors;

class InputMapper {
    private InputMapper() {}

    static PurchaseInfo getPurchaseInfo() {
        PurchaseDto dto = InputView.getPurchaseDto();
        return new PurchaseInfo(
                dto.getPurchaseMoney(),
                dto.getNumOfManualLottos(),
                dto.getManualLottos().stream().map((lotto) -> parseLotto(lotto)).collect(Collectors.toList())
        );
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
