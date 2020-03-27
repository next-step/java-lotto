package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        validateNumberRange(lottoNumbers);
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

    private void validateNumberRange(List<Integer> lottoNumbers) {
        boolean hasNumberOutOfRange = lottoNumbers.stream()
                .filter(number -> number > LOTTO_NUMBER_MAX || number < LOTTO_NUMBER_MIN)
                .findAny()
                .isPresent();
        if (hasNumberOutOfRange) {
            throw new IllegalArgumentException("로또는 1부터 45까지의 숫자로만 구성되어야 합니다.");
        }
    }

    public int findHowManyMatch(List<Integer> winningLotto) {
            return this.lottoNumbers.stream()
                    .filter(it -> winningLotto.contains(it))
                    .collect(Collectors.toList())
                    .size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}