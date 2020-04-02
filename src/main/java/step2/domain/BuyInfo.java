package step2.domain;

import java.util.List;
import java.util.Set;

public class BuyInfo {
    private int buyLottoTotalPrice;
    private int buyLottoCount;
    private Set<List<Integer>> buyLottoList;

    public int getBuyLottoTotalPrice() {
        return buyLottoTotalPrice;
    }

    public Set<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }

    public void setBuyLottoList(Set<List<Integer>> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public int getBuyLottoCount() {
        return buyLottoCount;
    }

    public BuyInfo(int totalPrice, int pricePerGame) {
        if (totalPrice < pricePerGame) {
            throw new IllegalArgumentException(pricePerGame + "보다 큰 금액입력");
        }
        this.buyLottoTotalPrice = totalPrice;
        this.buyLottoCount = totalPrice / pricePerGame;
    }
}
