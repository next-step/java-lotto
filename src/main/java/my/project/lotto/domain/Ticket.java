package my.project.lotto.domain;

import my.project.utils.IntUtils;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Ticket {
    public static final int PRICE = 1000;

    private final int count;

    public Ticket(int money) {
        IntUtils.isMoneyQualified(money);
        this.count = money / PRICE;
    }

    public int getCount() {
        return this.count;
    }

}
