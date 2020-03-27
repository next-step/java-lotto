package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        int sizeOfSet = lottoNumbers.stream()
                .collect(Collectors.toSet())
                .size();
        if (lottoNumbers.size() > sizeOfSet) {
            throw new IllegalArgumentException("로또는 중복되지 않은 숫자로 구성되어야 합니다.");
        }
    }
}