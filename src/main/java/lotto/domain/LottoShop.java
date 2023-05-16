package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {

    public static final int THOUSAND = 1000;

    private LottoShop() {
    }

    public static Lottos buyLotto(int payment) {
        ExceptionHandler.validPrice(payment);
        return Stream.generate(Lotto::createLottoNumber)
                .limit(payment / THOUSAND)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::of));
    }
}



