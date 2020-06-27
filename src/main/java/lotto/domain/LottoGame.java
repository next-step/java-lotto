package lotto.domain;

import lotto.view.Input;

import static lotto.domain.Lotto.LOTTO_GAME_PRICE;

public class LottoGame {

    private int totalGame;
    private int autoGame;
    private int selectGame;

    public LottoGame(Money money, int selectCount) {
        totalGame = money.getMoney() / LOTTO_GAME_PRICE;
        this.autoGame = setAutoCount(selectCount);
    }

    private int setAutoCount(int selectCount) {
        try {
            if (totalGame < selectCount) {
                throw new IllegalArgumentException("수동구매가 총 구매한 게임 수를 넘을 수 없습니다.");
            }
            return totalGame - selectCount;
        } catch (Exception error) {
            error.getMessage();
            return setAutoCount(Input.inputSelectLottoCount());
        }

    }

    public int getAutoGame() {
        return this.autoGame;
    }

    public int getSelectGame() {
        return this.selectGame;
    }

}
