package LottoTests.model;

import lotto.model.wrapper.LottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumberAdaptor {
    public static List<LottoNumber> convert(List<Integer> origin) {
        if(Objects.isNull(origin)) {
            return null;
        }

        return origin.stream()
                .map(LottoNumber::newInstance)
                .collect(Collectors.toList());
    }
}
