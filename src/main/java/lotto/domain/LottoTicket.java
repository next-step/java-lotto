package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicateNumbers(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
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

    public boolean isContainingLottoNumbers(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
