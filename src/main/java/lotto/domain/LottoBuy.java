package lotto.domain;

import java.util.Map;

public class LottoBuy {

    private final LottoBuyCount lottoBuyCount;
    private final LottoTickets lottoTickets;

    public LottoBuy(int buyPrice) {
        lottoBuyCount = new LottoBuyCount(buyPrice);
        lottoTickets = new LottoTickets(lottoBuyCount);
    }

    public LottoBuy(String lottoTicketString) {
        lottoBuyCount = new LottoBuyCount(lottoTicketString);
        lottoTickets = new LottoTickets(lottoTicketString);
    }

    public boolean lottoBuyCountIsEqualTo(int otherLottoCount) {
        return this.lottoBuyCount.isEqualTo(otherLottoCount);
    }

    @Override
    public String toString() {
        return lottoBuyCount + "개를 구매했습니다.\n" + lottoTickets;
    }

    public Map<Integer, Integer> calculateLottoWinStatistics(LottoWinNumber lottoWinNumber) {
        return lottoTickets.calculateLottoWinStatistics(lottoWinNumber);
    }

    public int getLottoBuyPrice() {
        return lottoBuyCount.getLottoBuyPrice();
    }
}
