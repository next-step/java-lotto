package my.project.lotto.domain;

import my.project.constants.Comments;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Ticket {
    public static final int PRICE = 1000;
    private final int tickets;

    public Ticket(int money) {
        isQualified(money);
        this.tickets = money / PRICE;
    }

    private void isQualified(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(Comments.MIN_MONEY);
        }
    }

    public int getTickets() {
        return tickets;
    }

}
