package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static int getLottoCount(int money) {
        int count = money / Lotto.PRICE;

        validateMoney(money, count);

        return count;
    }

    private static void validateMoney(int money, int count) {
        if (count * Lotto.PRICE != money) {
            throw new IllegalArgumentException("거스름돈은 반환이 불가능합니다. 로또는 " + Lotto.PRICE + "원 입니다.");
        }
    }

    public static LottoGame buyLottoGame(int count) {

        return new LottoGame(IntStream.range(0, count)
                .mapToObj(a -> LottoAutoMaker.makeLotto())
                .collect(Collectors.toList()));

    }
}
