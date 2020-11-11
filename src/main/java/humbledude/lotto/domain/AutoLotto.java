package humbledude.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {

    private AutoLotto() {}

    public static LottoTicket buildTicket() {
        List<Integer> lottoTotalNumbers = getLottoTotalNumbers();
        LottoNumbers numbers = LottoNumbers.of(pickRandomNumbers(lottoTotalNumbers));
        return new LottoTicket(numbers);
    }

    private static List<Integer> getLottoTotalNumbers() {
        return IntStream.rangeClosed(LottoNumbers.LOTTO_MIN, LottoNumbers.LOTTO_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    private static Set<Integer> pickRandomNumbers(List<Integer> lottoTotalNumbers) {
        Collections.shuffle(lottoTotalNumbers);
        return lottoTotalNumbers.stream()
                .limit(LottoNumbers.LOTTO_SIZE_OF_NUMBERS)
                .collect(Collectors.toSet());
    }
}
