package lotto.utils;

import lotto.model.wrapper.LottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberAdaptor {

    private LottoNumberAdaptor() {
    }

    public static Set<LottoNumber> convert(final List<Integer> origin) {
        if (Objects.isNull(origin)) {
            return null;
        }

        return origin.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
