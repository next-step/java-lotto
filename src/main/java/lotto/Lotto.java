package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.MatchType;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    public static int matchCount(LottoNumbers myLottoNumbers, LottoNumbers winningLottoNumbers) {
        List<LottoNumber> matchNumbers = myLottoNumbers.value().stream()
                .filter(m -> winningLottoNumbers.value().stream()
                        .anyMatch(Predicate.isEqual(m))).collect(Collectors.toList());
        return matchNumbers.size();
    }

    public static long reward(int matchCount) {
        return MatchType.of(matchCount).reward();
    }
}
