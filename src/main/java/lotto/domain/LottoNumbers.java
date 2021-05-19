package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final Set<Integer> lottoNumbers;

    private LottoNumbers(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(int... lottoNumber) {
        this(initNumbers(lottoNumber));
    }

    private static Set<Integer> initNumbers(int[] lottoNumber) {
        return Arrays.stream(lottoNumber)
                    .boxed()
                    .collect(Collectors.toSet());
    }

    public Set<Integer> getValue() {
        return new TreeSet<>(lottoNumbers);
    }

    public int matchNumbers(LottoNumbers lottoNumbers) {
        return 0;
    }
}
