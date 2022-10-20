package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {

    public WinningLotto(Set<LottoNumber> elements) {
        super(elements);
    }

    public static WinningLotto from(final List<String> values) {
        Set<LottoNumber> lottoNumbers = values.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new WinningLotto(lottoNumbers);
    }
}
