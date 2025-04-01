package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int PRICE = 1000;

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (lottoNumbers.stream().anyMatch(number -> number < LOTTO_MIN || number > LOTTO_MAX)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }

        if (lottoNumbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
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
