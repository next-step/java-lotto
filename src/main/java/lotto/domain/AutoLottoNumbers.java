package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoNumbers {

    public static final int LOTTO_INDEX_START = 0;
    public static final int LOTTO_INDEX_END = 6;
    private static final List<Integer> lottoNumbers = LottoNumber.create();

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
