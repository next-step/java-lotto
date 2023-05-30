package lotto.domain;

public class LottoBuy {

    private final LottoBuyCount lottoBuyCount;
    private final LottoTickets lottoTickets;

    public LottoBuy(int buyPrice) {
        lottoBuyCount = new LottoBuyCount(buyPrice);
        lottoTickets = new LottoTickets(lottoBuyCount.buyLotto());
    }

    public boolean lottoBuyCountIsEqualTo(int otherLottoCount) {
        return this.lottoBuyCount.isEqualTo(otherLottoCount);
    }

    @Override
    public String toString() {
        return lottoBuyCount.toString() + "개를 구매했습니다.\n" +
                lottoTickets.toString();
    }
}
