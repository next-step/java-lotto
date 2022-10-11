package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoVendingMachine {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoVendingMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<LottoNumber> makeLottoNumberWithTimes(int times) {
        return IntStream.range(0, times)
                .mapToObj(i -> makeLottoNumber())
                .collect(Collectors.toList());
    }

    private LottoNumber makeLottoNumber() {
        return lottoNumberGenerator.create();
    }
}
