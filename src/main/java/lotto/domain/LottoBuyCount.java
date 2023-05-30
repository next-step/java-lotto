package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyCount {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoBuyCount;

    LottoBuyCount(int buyPrice) {
        this.lottoBuyCount = buyPrice / LOTTO_PRICE;
    }

    public boolean isEqualTo(int otherLottoCount) {
        return this.lottoBuyCount == otherLottoCount;
    }

    public List<LottoTicket> buyLotto() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i=0; i<lottoBuyCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoBuyCount);
    }
}
