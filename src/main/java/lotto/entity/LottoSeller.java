package lotto.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.entity.Lotto.*;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;
    public static final String LOTTO_PRICE_1000 = "로또는 1장에 천원입니다.";

    public List<Lotto> buyLotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE_1000);
        }

        var lottoCount = money / LOTTO_PRICE;
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(randomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> randomNumbers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.shuffle(list);
                            return list.subList(0, LOTTO_NUMBER_COUNT);
                        }
                ));
    }
}
