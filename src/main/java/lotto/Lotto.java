package lotto;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Lotto {

    static Set<LottoNumber> makeLottoNumberSet(Stream<Integer> stream) {
        return stream
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }


    Set<LottoNumber> getLotto();

    int match(Lotto winningLotto);

    boolean contains(LottoNumber lottoNumber);
}
