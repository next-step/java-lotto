package lotto.domain;

import lotto.domain.number.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.number.LottoNumber.LOTTO_NUMBER_UNDER_BOUND;
import static lotto.domain.number.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        validateSize(lottoNumbers);
        validateDuplicateNumbers(lottoNumbers);
    }

    public LottoTicket() {
        this.lottoNumbers = peekLottoNumbers();
        validateSize(lottoNumbers);
        validateDuplicateNumbers(lottoNumbers);
    }

    private List<LottoNumber> peekLottoNumbers() {
        List<Integer> numbers = generateNumbers();

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        return IntStream.rangeClosed(LOTTO_NUMBER_UNDER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicateNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(lottoNumbers);

        if (nonDuplicateNumbers.size() < LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public long findMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumbers.stream()
                .filter(this::isContainingLottoNumbers)
                .count();
    }

    public boolean isContainingLottoNumbers(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
