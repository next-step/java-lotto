package com.lotto.model;

import com.lotto.game.Game;

public class LottoTicketInfo {
    private int manualCount;
    private int autoCount;

    public LottoTicketInfo(int money, int manualCount) {
        int allCount = money / Game.LOTTO_PRICE;

        if (allCount < manualCount) {
            throw new IllegalArgumentException("수동 구매 갯수가 실제 구매가능한 갯수보다 많습니다.");
        }

        this.manualCount = manualCount;
        this.autoCount = allCount - manualCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
