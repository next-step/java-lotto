package lotto.testrandom;


import lotto.domain.LottoNumber;
import lotto.random.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoList implements LottoGenerator {
    @Override
    public List<LottoNumber> executeStrategy() {
        return IntStream.range(1, 7).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }
}
