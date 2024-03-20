package lotto.domian;

import lotto.common.ConstantSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private final List<LottoNumber> numbers = generateImmutableLottoNumberList();

    public LottoNumberGenerator() {}

    public List<LottoNumber> generateRandomLottoNumbers() {
        List<LottoNumber> shuffledNumbers = new ArrayList<>(numbers);
        Collections.shuffle(shuffledNumbers);
        return  shuffledNumbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> generateImmutableLottoNumberList() {
        return Collections.unmodifiableList(
                IntStream.rangeClosed(ConstantSet.MIN_LOTTO_NUMBER, ConstantSet.MAX_LOTTO_NUMBER)
                        .mapToObj(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }
}
