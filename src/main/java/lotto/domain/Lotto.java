package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers)
            .map(i -> LottoNumber.of(i.trim()))
            .collect(toList()));
    }

    public Lotto(List<LottoNumber> collect) {
        lottoNumbers = new TreeSet<>(collect);
    }
}
