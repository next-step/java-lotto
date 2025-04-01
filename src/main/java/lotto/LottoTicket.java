package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    public static final int PRICE = 1000;

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
