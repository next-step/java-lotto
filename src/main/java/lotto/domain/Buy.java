package lotto.domain;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Buy {

    private final int price;
    private final int pay;
    private final int count;

    public Buy(int price, int pay) {
        this.price = price;
        this.pay = pay;
        this.count = calculateCount(price, pay);
    }

    private int calculateCount(int price, int pay) {
        if (pay % price != 0 ) {
            throw new IllegalArgumentException("잘못된 구매 금액 입니다");
        }
        return pay / price;
    }

    public int getCount() {
        return count;
    }
}
