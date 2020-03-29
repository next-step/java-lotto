package lotto.model.mylottos;

import lotto.model.winninglotto.BonusBall;
import lotto.model.winninglotto.WinningLotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
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
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() > uniqueNumbers.size()) {
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

    public int findHowManyMatch(WinningLotto winningLotto) {
        return this.lottoNumbers.stream()
                .filter(it -> winningLotto.contains(it))
                .collect(Collectors.toList())
                .size();
    }

    public boolean hasBonusBall(BonusBall bonusBall) {
        return lottoNumbers.stream()
                .filter(number -> bonusBall.isEqualWith(number))
                .findAny()
                .isPresent();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}