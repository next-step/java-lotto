package lotto.domain.publish;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoGenerator {

    static final int MINIMUM_LOTTO_QUANTITY = 1;

    private final LottoNumbersPicker lottoNumbersPicker;

    public LottoGenerator(final LottoNumbersPicker lottoNumbersPicker) {
        this.lottoNumbersPicker = lottoNumbersPicker;
    }

    public List<Lotto> generateLottos(final int quantity) {
        validateQuantityIsMoreThanMinimum(quantity);

        return IntStream.rangeClosed(1, quantity)
                .mapToObj(i -> generate())
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateQuantityIsMoreThanMinimum(final int quantity) {
        if (quantity < MINIMUM_LOTTO_QUANTITY) {
            throw new IllegalArgumentException("로또 구매 개수는 1이상의 자연수여야 합니다. 개수: " + quantity);
        }
    }

    private Lotto generate() {
        final Set<LottoNumber> lottoNumbers = this.lottoNumbersPicker.pick();

        return new Lotto(lottoNumbers);
    }
}
