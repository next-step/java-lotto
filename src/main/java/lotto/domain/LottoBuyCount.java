package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyCount {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoBuyCount;

    LottoBuyCount(int buyPrice) {
        this.lottoBuyCount = buyPrice / LOTTO_PRICE;
    }

    public LottoBuyCount(String lottoTicketString) {
        this.lottoBuyCount = lottoTicketString.split("\n").length;
    }

    public boolean isEqualTo(int otherLottoCount) {
        return this.lottoBuyCount == otherLottoCount;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoBuyCount);
    }

    public int getLottoBuyCount() {
        return lottoBuyCount;
    }

    public int getLottoBuyPrice() {
        return lottoBuyCount * LOTTO_PRICE;
    }
}
