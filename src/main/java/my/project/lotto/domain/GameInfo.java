package my.project.lotto.domain;

import my.project.constants.Rule;
import my.project.utils.IntUtils;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class GameInfo {
    private final int count;

    public GameInfo(int money) {
        IntUtils.isMoneyQualified(money);
        this.count = money / Rule.ONE_GAME_PRICE;
    }

    public int getCount() {
        return this.count;
    }

}
