package lotto.domain.lotto;

import lotto.domain.Money;
import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import lotto.domain.lotto.strategy.RandomNumbersCreateStrategy;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBERS_LENGTH;
import static util.Preconditions.checkArgument;

public class LottoTicket {
    private static final Money PRICE = Money.of(1000);
    private static final LottoNumbersCreateStrategy DEFAULT_CREATE_NUMBER_STRATEGY = new RandomNumbersCreateStrategy();
    public static final String LOTTO_NUMBER_MUST_NOT_BE_NULL = "lotto number must not be null";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED = "lotto number must not be duplicated";

    private final LottoNumbers lottoNumbers;

    private LottoTicket(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(final LottoNumbers lottoNumbers) {
        checkArgument(lottoNumbers != null, LOTTO_NUMBER_MUST_NOT_BE_NULL);
        checkArgument(hasNotDuplicates(lottoNumbers), LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket of(final LottoNumbersCreateStrategy lottoNumbersStrategy) {
        return of(lottoNumbersStrategy.create());
    }

    public static LottoTicket of() {
        return of(DEFAULT_CREATE_NUMBER_STRATEGY);
    }

    public static LottoTicket of(final String lottoNumberExpression) {
        return of(LottoNumbers.of(lottoNumberExpression));
    }

    public static boolean hasNotDuplicates(final LottoNumbers lottoNumbers) {
        return !hasDuplicates(lottoNumbers);
    }

    public static boolean hasDuplicates(final LottoNumbers lottoNumbers) {
        final Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers.get());
        return lottoNumberSet.size() < lottoNumbers.size();
    }

    public int countHitNumber(final LottoTicket winLottoTicket) {
        return lottoNumbers.countHitNumber(winLottoTicket.lottoNumbers);
    }

    public boolean isMatchBonus(final LottoNumber bonusNumber) {
        return lottoNumbers.get()
                .stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    public static Money getPrice() {
        return PRICE;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumbers.get().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
