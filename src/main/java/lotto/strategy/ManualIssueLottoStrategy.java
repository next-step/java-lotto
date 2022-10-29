package lotto.strategy;

import static lotto.exception.ExceptionMessage.ERROR_MISMATCH_QUANTITY;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class ManualIssueLottoStrategy implements IssueLottoStrategy {

    public final List<String> lottoNumbers;

    public ManualIssueLottoStrategy(final List<String> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Lotto> issue(final int number) {
        validateQuantity(number);
        return lottoNumbers.stream()
            .map(Lotto::new)
            .collect(Collectors.toList());
    }

    private void validateQuantity(final int number) {
        if (lottoNumbers.size() != number) {
            throw new IllegalArgumentException(ERROR_MISMATCH_QUANTITY.getMessage());
        }
    }
}
