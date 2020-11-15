package lotto.domain.lotto;

import java.util.List;

public class LottoNumberDuplicateChecker {
    public static boolean hasNotDuplicates(final List<LottoNumber> numbers) {
        return !hasDuplicates(numbers);
    }
    
    public static boolean hasDuplicates(final List<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .distinct()
                .count() != numbers.size();
    }
}
