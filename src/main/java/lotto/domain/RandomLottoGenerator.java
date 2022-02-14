package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    private static final List<Integer> lottoRange = IntStream.rangeClosed(START_RANGE, END_RANGE)
        .boxed().collect(
            Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    public RandomLottoGenerator(){
        Collections.shuffle(lottoRange);
        List<Integer> subNumbers = lottoRange.stream().limit(COUNT).sorted()
            .collect(Collectors.toList());
        this.lottoNumbers = subNumbers.stream().map(LottoNumber::new).collect(
            Collectors.toList());
    }

    @Override
    public List<LottoNumber> getLottoGeneratorNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
