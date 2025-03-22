package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;
    public final LottoFactory lottoFactory = new LottoFactory();

    public List<Lotto> buy(int money) {
        int lottoCount = money / LOTTO_PRICE;

        return IntStream.range(0, lottoCount)
            .mapToObj(i -> lottoFactory.createLotto())
            .collect(Collectors.toList());
    }

}
