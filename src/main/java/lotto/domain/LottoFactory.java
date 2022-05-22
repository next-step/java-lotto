package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    public static LottoNumbers createAutoLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> lottoNumbers = LottoFactory.lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted(Comparator.comparing(x -> x.getNumber().getNumber()))
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }

}
