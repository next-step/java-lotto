package step2.utils;

public class CalculateUtils {

    public static final int EACH_LOTTO_PRICE = 1000;

    public static int lottoCount(int payPrice) {
        if (payPrice % EACH_LOTTO_PRICE != 0 || payPrice / EACH_LOTTO_PRICE < 0) {
            throw new IllegalArgumentException("금액을 잘못 입력 하였습니다. 로또 한장의 가격은 " + EACH_LOTTO_PRICE + "원 입니다.");
        }

        return payPrice / EACH_LOTTO_PRICE;
    }
}
