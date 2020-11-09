package humbledude.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_SIZE_OF_NUMBERS = 6;

    private Set<Integer> numbers;

    public LottoTicket() {
        numbers = generateNumbers();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private Set<Integer> generateNumbers() {
        List<Integer> lottoTotalNumbers = getLottoTotalNumbers();
        return pickRandomNumbers(lottoTotalNumbers);
    }

    private List<Integer> getLottoTotalNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    private Set<Integer> pickRandomNumbers(List<Integer> lottoTotalNumbers) {
        Collections.shuffle(lottoTotalNumbers);
        return lottoTotalNumbers.stream()
                .limit(LOTTO_SIZE_OF_NUMBERS)
                .collect(Collectors.toSet());
    }

}
