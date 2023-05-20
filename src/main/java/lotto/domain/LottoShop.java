package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {

    public static final int THOUSAND = 1000;

    private LottoShop() {
    }

    public static Lottos buyLotto(int payment) {
        validPrice(payment);
        return Stream.generate(Lotto::createLottoNumber)
                .limit(payment / THOUSAND)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::of));
    }

    private static void validPrice(int payment) {
        if (payment < THOUSAND) {
            throw new IllegalArgumentException("로또 최소 구매 금액은 1000원 입니다");
        }
    }
}



