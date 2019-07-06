package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != 6){
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lotto){
        return new Lotto(makeLottoNumberSet(lotto.stream()));
    }

    public static Lotto of(Set<Integer> lotto){
        return new Lotto(makeLottoNumberSet(lotto.stream()));
    }

    private static Set<LottoNumber> makeLottoNumberSet(Stream<Integer> stream) {
        return stream
                .map(x -> new LottoNumber(x))
                .collect(Collectors.toSet());
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }
}
