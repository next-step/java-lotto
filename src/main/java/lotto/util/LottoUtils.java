package lotto.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoUtils {

    private static final int LOTTO_PRICE = 1000;

    public static int getLottoGameCount(int price) {

        if(isMinLottoPrice(price)){
            throw new InputMismatchException("로또 최소 구매 금액은 1000원 입니다. 입력값 : " + price);
        }

        return price / LOTTO_PRICE;
    }

    private static boolean isMinLottoPrice(int price) {
        return price < LOTTO_PRICE;
    }

    public static double calRateOfReturn(Long totalWinningPrice, int buyPrice) {

        return 1 + (totalWinningPrice - buyPrice) / (double) buyPrice;
    }
}
