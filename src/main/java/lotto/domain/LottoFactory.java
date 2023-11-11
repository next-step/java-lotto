package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<Integer> LOTTO_NUMBER_LIST = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    public static MyLottos buy(Money money) {
        int purchaseCount = money.purchaseCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(generateRandomLotto());
        }
        return new MyLottos(lottos);
    }

    private static Lotto generateRandomLotto() {
        Collections.shuffle(LOTTO_NUMBER_LIST, new Random());
        return new Lotto(new ArrayList<>(LOTTO_NUMBER_LIST.subList(0, 6)));
    }
}
