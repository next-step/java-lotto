package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.StringResources;

public class LottoCreator {

    private static final List<Integer> ORIGINAL_LOTTO_NUMBERS =
            Stream.iterate(1, i -> i + 1)
                    .limit(45)
                    .collect(Collectors.toList());

    private static final Random RANDOM_INSTANCE = new Random();

    public static List<LottoNumber> create(final int money) {

        verifyPositiveMoney(money);
        verifyMoneyUnit(money);

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < money / 1000; i++) {
            Collections.shuffle(ORIGINAL_LOTTO_NUMBERS, RANDOM_INSTANCE);
            lottoNumberList.add(new LottoNumber(new Number(
                    ORIGINAL_LOTTO_NUMBERS.subList(0, Number.LOTTO_NUMBERS_SIZE))));
        }

        return lottoNumberList;
    }

    private static void verifyPositiveMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }
    }

    private static void verifyMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }
    }
}
