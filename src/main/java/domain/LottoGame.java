package domain;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static double getTotalEarningRate(int price, int rewards) {
        double result = (double) rewards / (double) price;
        if (price == 0 || rewards == 0) {
            result = 0;
        }
        return result;
    }

    public static int buyLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        return lottoCount;
    }
}
