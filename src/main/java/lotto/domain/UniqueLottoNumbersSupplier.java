package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class UniqueLottoNumbersSupplier implements LottoNumbersSupplier {

    @Override
    public LottoNumbers get() {
        return new LottoNumbers(mapToLottoNumbers(pickUniqueNumbers()));
    }

    private static List<Integer> pickUniqueNumbers() {
        return RandomUtils.pickUniqueNumbersInRange(
            LottoNumber.MIN,
            LottoNumber.MAX,
            LottoNumbers.SIZE);
    }

    private static List<LottoNumber> mapToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList());
    }
}
