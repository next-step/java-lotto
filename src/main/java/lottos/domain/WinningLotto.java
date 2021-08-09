package lottos.domain;

import lottos.domain.exceptions.LottoDuplicationNumberException;
import lottos.domain.numbers.Number;
import lottos.domain.numbers.Numbers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {

    private static final int COUNT_OF_LOTTO = 6;
    private static final int COUNT_OF_BONUS_NUMBER = 1;

    private final Numbers numbers;
    private final Number bonusNumber;

    public WinningLotto(final List<Integer> numbers, final Integer bonusNumber) {
        this.numbers = Numbers.from(numbers);
        this.bonusNumber = Number.valueOf(bonusNumber);
        checkDuplicateNumbers(numbers, bonusNumber);
    }

    private void checkDuplicateNumbers(final List<Integer> numbers, final Integer bonusNumber) {
        Set<Integer> distinctNumbers = Stream.of(numbers, Collections.singletonList(bonusNumber))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        if (distinctNumbers.size() != COUNT_OF_LOTTO + COUNT_OF_BONUS_NUMBER) {
            throw new LottoDuplicationNumberException();
        }
    }

    public LottoResult match(final Lotto purchaseLotto) {
        int countOfMatchers = this.numbers.match(purchaseLotto.getNumbers());
        boolean isBonus = purchaseLotto.getNumbers()
                .elements()
                .stream()
                .anyMatch(number -> number.equals(this.bonusNumber));
        return new LottoResult(LottoPrize.valueOf(countOfMatchers, isBonus));
    }

    public List<LottoResult> match(final Lottos purchaseLottos) {
        return purchaseLottos.elements()
                .stream()
                .map(this::match)
                .collect(Collectors.toList());
    }
}
