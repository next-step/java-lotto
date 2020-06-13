package lotto.model;

public class LottoStatic {
    public int buyLottos(int budget) {
        int purchase =  budget / Lotto.LOTTO_PRICE;

        return purchase;
    }

    public int getPrizeMoney(Lotto.Rank rank) {
        return rank.getPrize();
    }
}
