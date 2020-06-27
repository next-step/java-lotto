package lotto.domain;

import lotto.view.Input;

import static lotto.domain.Lotto.LOTTO_GAME_PRICE;

public class LottoGame {

    private int totalGame;
    private int autoGame;
    private int selectGame;

    public LottoGame(Money money, int selectCount) {
        this((money.getMoney() / LOTTO_GAME_PRICE), selectCount);
    }

    public LottoGame(int totalGame, int selectCount) {
        this.totalGame = totalGame;
        int autoGameCount = setAutoCount(selectCount);
        this.autoGame = autoGameCount;
        this.selectGame = totalGame - autoGameCount;
    }

    private int setAutoCount(int selectCount) {
        try {
            if (totalGame < selectCount) {
                throw new IllegalArgumentException("수동구매가 총 구매한 게임 수를 넘을 수 없습니다.");
            }
            return totalGame - selectCount;
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return setAutoCount(Input.inputSelectLottoCount());
        }

    }

    public int getAutoGame() {
        return this.autoGame;
    }

    public int getSelectGame() {
        return this.selectGame;
    }

    public int getTotalGame() {
        return this.totalGame;
    }

}
