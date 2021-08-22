package com.lotto.model;

import com.lotto.game.Game;

public class LottoMoney {
    private int money;

    public LottoMoney(int money) {
        if (money < Game.LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 금액보다 적은 값이 입력되었습니다.");
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
