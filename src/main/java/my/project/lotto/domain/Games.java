package my.project.lotto.domain;

import my.project.constants.Rule;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Games {
    private int count;

    public Games(int inputMoney) {
        count(inputMoney);
    }

    private void count(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException(Rule.MIN_MONEY);
        }
        this.count = inputMoney / Rule.ONE_GAME_PRICE;
    }

    public void game() {
        for (int i = 0; i < count; i++) {
            Game game = new Game();

        }
    }
}
