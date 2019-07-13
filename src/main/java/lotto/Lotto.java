package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Lotto {
    static LottoAuto of(String lotto) {
        Set<Integer> lottoSet = Arrays.stream(lotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return new LottoAuto(makeLottoNumberSet(lottoSet.stream()));
    }

    static LottoAuto of(List<Integer> lotto) {
        return new LottoAuto(makeLottoNumberSet(lotto.stream()));
    }

    static LottoAuto of(Set<Integer> lotto) {
        return new LottoAuto(makeLottoNumberSet(lotto.stream()));
    }

    private static Set<LottoNumber> makeLottoNumberSet(Stream<Integer> stream) {
        return stream
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }


    Set<LottoNumber> getLotto();

    int match(Lotto winningLotto);

    boolean contains(LottoNumber lottoNumber);
}
