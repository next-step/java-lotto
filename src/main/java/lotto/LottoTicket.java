package lotto;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoNumber.LOTTO_MAX;
import static lotto.LottoNumber.LOTTO_MIN;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;
    public static final int PRICE = 1000;

    private static final List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
            .boxed()
            .collect(Collectors.toList());

    private final TreeSet<LottoNumber> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public LottoTicket(TreeSet<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(List<Integer> numbers) {
        this(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(TreeSet::new)));
    }

    private static void validateSize(TreeSet<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private TreeSet<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_SIZE);

        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public TreeSet<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }
}
