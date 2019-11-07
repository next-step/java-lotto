package com.seok2.lotto.domain;

public class LottoStrategyFactory {

    private final static LottoStrategy AUTO = new AutoLottoStrategy();

    static LottoStrategy get(LottoSheetRow lottoSheetRow) {
        if(lottoSheetRow.isAuto())
            return AUTO;
        return new ManualLottoStrategy(lottoSheetRow);
    }
}
