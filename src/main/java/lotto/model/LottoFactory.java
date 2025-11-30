package lotto.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {
    public static Lotto createLotto(String lottoString) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(lottoString.split(","))
                .map(String::trim)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }
}
