package step2.utils;

public class CalculateUtils {

    public static final int EACH_LOTTO_PRICE = 1000;

    public static int lottoCount(int payPrice) {
        return payPrice / EACH_LOTTO_PRICE;
    }
}
