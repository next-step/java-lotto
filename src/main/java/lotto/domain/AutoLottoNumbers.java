package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumbers {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private static final List<Integer> lottoNumbers = IntStream.range(MIN, MAX)
            .boxed()
            .collect(Collectors.toList());
    public static final int LOTTO_INDEX_START = 0;
    public static final int LOTTO_INDEX_END = 6;

    private AutoLottoNumbers() {}

    public static List<LottoNumber> autoCreate(final long count) {

        final List<LottoNumber> autoLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoNumbers);
            autoLottoNumbers.add(LottoNumber.from(pick()));
        }
        return autoLottoNumbers;
    }

    private static List<Integer> pick() {

        return lottoNumbers.subList(LOTTO_INDEX_START, LOTTO_INDEX_END)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
