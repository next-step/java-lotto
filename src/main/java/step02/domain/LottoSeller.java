package step02.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    public static LottoList sell(int price) {
        return new LottoList(
            IntStream.range(0, getLottoCount(price))
                .mapToObj(i -> Lotto.create())
                .collect(Collectors.toList())
        );
    }

    private static int getLottoCount(int price) {
        validatePrice(price);
        return price / LOTTO_PRICE;
    }

    private static void validatePrice(int price) {
        validatePriceAmount(price);
        validatePriceRange(price);
    }

    private static void validatePriceAmount(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("금액은 0원 이하의 금액을 입력할 수 없습니다. | 입력한 금액: " + price);
        }
    }

    private static void validatePriceRange(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 " + LOTTO_PRICE + " 단위의 금액을 입력해야합니다. | 입력된 금액: " + price);
        }
    }
}
