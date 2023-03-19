package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class RandomNumberFactory {
    public static int[] get() {
        List<Integer> lottoNumberList = Arrays.stream(IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).toArray()).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberList);
        return lottoNumberList.subList(0, LOTTO_NUMBER_COUNT).stream().mapToInt(i -> i).toArray();
    }
}
