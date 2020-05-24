package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_GENERATE_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private static final List<Integer> DEFAULT_NUMBERS;

    static {
        DEFAULT_NUMBERS = generateLottoNumbers();
    }

    public LottoTicket autoGenerate() {
        Collections.shuffle(DEFAULT_NUMBERS);
        LottoTicket lottoTicket = LottoTicket.of(DEFAULT_NUMBERS.subList(0, LOTTO_GENERATE_COUNT));
        lottoTicket.sort();
        return lottoTicket;
    }

    private static List<Integer> generateLottoNumbers() {
        return IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
