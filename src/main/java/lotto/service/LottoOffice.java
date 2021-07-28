package lotto.service;


import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoBunch;
import lotto.domain.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;

public class LottoOffice {
    private static final int LOTTO_NUMBER_MAKER_INITIAL_INDEX = 0;
    private static final Money LOTTO_PRICE_OF_SINGLE = Money.of(1000);
    private static final List<LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                    .mapToObj(LottoNumber::of)
                    .collect(Collectors.toList());

    private final Money money;

    public LottoOffice(Money money) {
        this.money = money;
    }
    
    public LottoBunch purchase() {
        List<Lotto> lottos = Stream.generate(this::generate)
                .map(Lotto::of)
                .limit(money.getPurchasableQuantity(LOTTO_PRICE_OF_SINGLE))
                .collect(Collectors.toList());

        return LottoBunch.of(lottos);
    }

    private List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return extractLottoNumber();
    }

    private static List<LottoNumber> extractLottoNumber() {
        return Collections.unmodifiableList(
                new ArrayList<>(LOTTO_NUMBERS.subList(LOTTO_NUMBER_MAKER_INITIAL_INDEX, LOTTO_NUMBER_COUNT))
        );
    }


}
