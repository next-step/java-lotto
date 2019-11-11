package com.seok2.lotto.domain.lotto;

import com.seok2.lotto.domain.order.LottoSheetRow;

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
