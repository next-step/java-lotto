package lotto.domain.publish;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.Lotto;

public class LottoGenerator {

    static final int MINIMUM_LOTTO_QUANTITY = 1;

    private final LottoNumbersPicker lottoNumbersPicker;

    public LottoGenerator(final LottoNumbersPicker lottoNumbersPicker) {
        this.lottoNumbersPicker = lottoNumbersPicker;
    }

    public List<Lotto> generateLottos(final int quantity) {
        validateQuantityIsMoreThanMinimum(quantity);

        return Stream.generate(this::generateLotto)
                .limit(quantity)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateQuantityIsMoreThanMinimum(final int quantity) {
        if (quantity < MINIMUM_LOTTO_QUANTITY) {
            throw new IllegalArgumentException("로또 구매 개수는 1이상의 자연수여야 합니다. 개수: " + quantity);
        }
    }

    private Lotto generateLotto() {
        final List<Integer> numbers = this.lottoNumbersPicker.pick();

        return Lotto.from(numbers);
    }
}
