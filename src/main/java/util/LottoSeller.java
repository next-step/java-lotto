package util;

import domain.Lotto;
import domain.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.LottoManager.createLotto;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    private LottoSeller(){
        throw new IllegalStateException("Utility class");
    }

    public static List<Lotto> buyLotto(Money money) {
        final int lottoCount = money.value() / LOTTO_PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toUnmodifiableList());
    }
}
