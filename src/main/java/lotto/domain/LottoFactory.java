package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final List<LottoNum> LOTTO_NUMBER_LIST = IntStream.range(1, 45).mapToObj(LottoNum::new).collect(Collectors.toList());

    public static MyLottos buy(Money money) {
        int purchaseCount = money.buyAllAutoLotto();
        return new MyLottos(
                Stream.generate(LottoFactory::generateRandomLotto)
                        .limit(purchaseCount).collect(Collectors.toList()));
    }

    private static Lotto generateRandomLotto() {
        Collections.shuffle(LOTTO_NUMBER_LIST, new Random());
        return new Lotto(new ArrayList<>(LOTTO_NUMBER_LIST.subList(0, 6)));
    }
}
