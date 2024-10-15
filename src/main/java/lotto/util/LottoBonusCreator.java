package lotto.util;

import lotto.model.dto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.BONUS_NUMBER_SIZE;
import static lotto.model.dto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.model.dto.LottoNumber.MIN_LOTTO_NUMBER;

public class LottoBonusCreator implements BonusCreator {
    public static final int FIRST_INDEX = 0;

    @Override
    public LottoNumber create() {
        List<Integer> integers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.stream()
                .limit(BONUS_NUMBER_SIZE)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList())
                .get(FIRST_INDEX);
    }

}
