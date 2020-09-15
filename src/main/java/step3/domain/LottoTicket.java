package step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Long> lottoNumbers;

    public LottoTicket(List<Long> lottoNumbers) throws IllegalAccessException {
        validationSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static int getLottoNumbersSize() {
        return LOTTO_NUMBERS_SIZE;
    }

    public List<Long> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validationSize(List<Long> lottoNumbers) throws IllegalAccessException {
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalAccessException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Long> lottoNumbers) throws IllegalAccessException {
        Set<Long> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if(nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalAccessException("로또 번호들은 중복될 수 없습니다.");
        }
    }
}
