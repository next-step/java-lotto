package lotto.domain;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateDuplicateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket ofFixed(List<Integer> numbers) {
        validateSize(numbers);
        return new LottoTicket(LottoNumberGenerator.generateFixedNumber(numbers));
    }

    public static LottoTicket ofAuto() {
        return new LottoTicket(LottoNumberGenerator.generateRandomNumber(LOTTO_NUMBERS_SIZE));
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public int findMatchCount(LottoTicket lottoTicket) {
        return (int) lottoTicket.lottoNumbers.stream()
                .filter(this::isContainingLottoNumbers)
                .count();
    }

    public boolean isContainingLottoNumbers(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다. - " + numbers);
        }
    }

    private static void validateDuplicateNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다. - " + lottoNumbers);
        }
    }
}
