package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_LENGTH = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(final List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        validateLottoNumbersLength(lottoNumbers);
        validateDuplicatedLottoNumber(lottoNumbers);
    }

    private void validateLottoNumbersLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("6자리의 수만 가능합니다.");
        }
    }

    private void validateDuplicatedLottoNumber(List<Integer> lottoNumbers) {
        List<Integer> distinctLottoNumbers = lottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinctLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
    }

}