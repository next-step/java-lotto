package lotto.domain.publish;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoGenerator {

    static final int MINIMUM_LOTTO_QUANTITY = 0;

    private final LottoNumbersPicker lottoNumbersPicker;

    public LottoGenerator(final LottoNumbersPicker lottoNumbersPicker) {
        this.lottoNumbersPicker = lottoNumbersPicker;
    }

    public List<Lotto> generateAutoLottos(final int quantity) {
        validateQuantityIsMoreThanMinimum(quantity);

        return Stream.generate(this::generateLotto)
                .limit(quantity)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateQuantityIsMoreThanMinimum(final int quantity) {
        if (quantity < MINIMUM_LOTTO_QUANTITY) {
            throw new IllegalArgumentException("자동 로또 개수는 최소 개수 미만일 수 없습니다. 개수: " + quantity);
        }
    }

    private Lotto generateLotto() {
        final Set<LottoNumber> numbers = this.lottoNumbersPicker.pick();

        return new Lotto(numbers);
    }

    public List<Lotto> generateManualLottos(final List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(Lotto::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
