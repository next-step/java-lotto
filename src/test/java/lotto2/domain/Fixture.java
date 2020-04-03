package lotto2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fixture {
    private static List<Integer> sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    public static List<LottoNumber> lottoNumbers() {
        return sixNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static Lotto oneLotto() {
        return new Lotto(lottoNumbers());
    }
}
