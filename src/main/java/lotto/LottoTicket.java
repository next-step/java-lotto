package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoNumber.LOTTO_MAX;
import static lotto.LottoNumber.LOTTO_MIN;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;
    public static final int PRICE = 1000;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        this.lottoNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
    }

    private static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        List<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private List<LottoNumber> generateLottoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);

        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .anyMatch(number -> number == lottoNumber.getNumber());
    }
}
