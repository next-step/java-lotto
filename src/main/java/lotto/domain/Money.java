package lotto.domain;

import lotto.view.Input;

import static lotto.domain.Lotto.LOTTO_GAME_PRICE;

public class Money {

    private static final int INIT_ZERO = 0;
    private int money;
    private int autoGameCount;
    private int selectGameCount;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int inputMoney) {
        if (inputMoney < LOTTO_GAME_PRICE) {
            throw new IllegalArgumentException("돈이 " + LOTTO_GAME_PRICE + "원 보다 작을 수 없습니다.");
        }
        autoGameCount = inputMoney / LOTTO_GAME_PRICE;
        this.money = inputMoney;
    }

    public int getAutoGameCount() {
        return autoGameCount;
    }

    public int getSelectGameCount() {
        return selectGameCount;
    }

    public void resetBuyCount(int selectCount) {

        if (autoGameCount < selectCount) {

            throw new IllegalArgumentException("수동으로 구매할 수 있는 게임 수가 구입금액을 넘을 수 없습니다.");
        }

        this.selectGameCount = selectCount;
        this.autoGameCount -= selectGameCount;
    }
}
