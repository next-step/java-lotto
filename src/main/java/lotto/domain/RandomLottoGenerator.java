package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    public static final int COUNT = 6;

    private static final List<Integer> lottoRange = IntStream.rangeClosed(START_RANGE, END_RANGE)
        .boxed().collect(
            Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    public RandomLottoGenerator() {
        Collections.shuffle(lottoRange);
        List<Integer> subNumbers = lottoRange.stream().limit(COUNT).sorted()
            .collect(Collectors.toList());
        if (lottoLengthValidation(subNumbers)) {
            throw new IllegalArgumentException("6개의 로또가 필요합니다");
        }
        this.lottoNumbers = subNumbers.stream().map(LottoNumber::new).collect(
            Collectors.toList());
    }

    private boolean lottoLengthValidation(List<Integer> line) {
        return line.size() != COUNT;
    }

    @Override
    public List<LottoNumber> getLottoGeneratorNumbers() {
        return lottoNumbers;
    }

}
