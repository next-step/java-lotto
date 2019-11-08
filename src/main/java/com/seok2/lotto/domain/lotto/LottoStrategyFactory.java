package com.seok2.lotto.domain.lotto;

import com.seok2.lotto.domain.order.LottoSheetRow;

public class LottoStrategyFactory {

    private final static LottoStrategy AUTO = new AutoLottoStrategy();

    public static LottoStrategy get(LottoSheetRow lottoSheetRow) {
        if (lottoSheetRow.isAuto()) {
            return AUTO;
        }
        return new ManualLottoStrategy(lottoSheetRow);
    }
}
