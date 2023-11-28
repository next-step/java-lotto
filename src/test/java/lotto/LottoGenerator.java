package lotto;

import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoType;

public class LottoGenerator {

    public static Lotto generate(Set<Integer> set) {
        return Lotto.winning(set.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }
}
