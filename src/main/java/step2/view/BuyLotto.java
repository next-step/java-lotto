package step2.view;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BuyLotto {
    private static int buyLottoTotalPrice;
    private static int buyLottoCount;
    private static Set<List<Integer>> buyLottoList;

    public static Set<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }

    public static void setBuyLottoList(Set<List<Integer>> buyLottoList) {
        BuyLotto.buyLottoList = buyLottoList;
    }



    public static int getBuyLottoCount() {
        return buyLottoCount;
    }

    public void setBuyLottoCount(int buyLottoCount) {
        this.buyLottoCount = buyLottoCount;
    }

    public BuyLotto(int buyLottoTotalPrice) {
        if (buyLottoTotalPrice <= 0) {
            throw new IllegalArgumentException("0원보다 큰 금액입력");
        }
        this.buyLottoTotalPrice = buyLottoTotalPrice;
    }

    public BuyLotto() {

    }

    public BuyLotto(int totalPrice, int pricePerGame) {
        if (totalPrice <= 0) {
            throw new IllegalArgumentException("0원보다 큰 금액입력");
        }

        this.buyLottoCount = totalPrice / pricePerGame;
    }


}
