package com.seok2.lotto.domain;

public class ManualLottoStrategy implements LottoStrategy {

    private final LottoSheetRow lottoSheetRow;

    ManualLottoStrategy(LottoSheetRow lottoSheetRow) {
        this.lottoSheetRow = lottoSheetRow;
    }

    @Override
    public Lotto generate() {
        return lottoSheetRow.exchange();
    }
}
