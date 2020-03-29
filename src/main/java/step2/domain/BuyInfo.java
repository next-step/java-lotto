package step2.domain;

import java.util.List;
import java.util.Set;

public class BuyInfo {
    private static int buyLottoTotalPrice;
    private static int buyLottoCount;
    private static Set<List<Integer>> buyLottoList;
    private static List<Integer> matchCountList;

    public static List<Integer> getMatchCountList() {
        return matchCountList;
    }

    public static void setMatchCountList(List<Integer> matchCountList) {
        BuyInfo.matchCountList = matchCountList;
    }


    public static Set<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }

    public static void setBuyLottoList(Set<List<Integer>> buyLottoList) {
        BuyInfo.buyLottoList = buyLottoList;
    }


    public BuyInfo() {

    }

    public static int getBuyLottoCount() {
        return buyLottoCount;
    }

    public void setBuyLottoCount(int buyLottoCount) {
        this.buyLottoCount = buyLottoCount;
    }

    public BuyInfo(int buyLottoTotalPrice) {
        if (buyLottoTotalPrice <= 0) {
            throw new IllegalArgumentException("0원보다 큰 금액입력");
        }
        this.buyLottoTotalPrice = buyLottoTotalPrice;
    }

    public BuyInfo(int totalPrice, int pricePerGame) {
        if (totalPrice <= 0) {
            throw new IllegalArgumentException("0원보다 큰 금액입력");
        }
        this.buyLottoTotalPrice = totalPrice;
        this.buyLottoCount = totalPrice / pricePerGame;
    }

    public static int match(int number) {
        return (int) matchCountList.stream().filter(d-> number == d).count();
    }
}
