package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoVendingMachine {

    public LottoVendingMachine() {
    }

    public static int calculateRandomNumberOfLotto(int totalNumberOfLotto, int manualNumberOfLotto) {
        return totalNumberOfLotto - manualNumberOfLotto;
    }

    public List<LottoNumber> makeLottoNumberWithTimes(LottoNumberGenerator lottoNumberGenerator, int times) {
        return IntStream.range(0, times)
                .mapToObj(i -> lottoNumberGenerator.create())
                .collect(Collectors.toList());
    }
}
