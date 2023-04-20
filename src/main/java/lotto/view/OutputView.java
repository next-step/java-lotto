package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.stream.IntStream;

public class OutputView {
    public static final int ZERO = 0;

    public static void printLottoQuantity(Money money) {
        System.out.println(money.getLottoQuantity() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        IntStream.range(ZERO, lottos.getLottoQuantity())
                .mapToObj(lottos::getLotto)
                .forEach(System.out::println);
    }

}
