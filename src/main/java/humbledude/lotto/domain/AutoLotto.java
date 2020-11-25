package humbledude.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {
    private static final List<LottoNumber> totalLottoNumbers;

    static {
        totalLottoNumbers = IntStream.rangeClosed(LottoNumber.LOTTO_MIN, LottoNumber.LOTTO_MAX)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private AutoLotto() {}


    public static LottoNumbers buildTicket() {
        Set<LottoNumber> numbers = pickRandomNumbers();
        return new LottoNumbers(numbers);
    }

    private static Set<LottoNumber> pickRandomNumbers() {
        Collections.shuffle(totalLottoNumbers);
        return totalLottoNumbers.stream()
                .limit(LottoNumbers.LOTTO_SIZE_OF_NUMBERS)
                .collect(Collectors.toSet());
    }
}
