package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constraint.Constraint;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(final List<LottoNumber> numbers) {
        validSizeCheck(numbers);
        validDuplicateCheck(numbers);
        lottoNumbers.addAll(numbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    public int getMatchCount(LottoNumbers winningNumbers) {
        int collectNumber = 0;
        List<LottoNumber> integerWinningNumbers = winningNumbers.getLottoNumbers();
        for (LottoNumber number : integerWinningNumbers) {
            collectNumber += checkContains(number);
        }
        return collectNumber;
    }

    private int checkContains(LottoNumber number) {
        if (lottoNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private void validSizeCheck(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Constraint.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또는 6자리가 되어야 합니다.");
        }
    }

    private void validDuplicateCheck(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != Constraint.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return "["
            + lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(","))
            + "]";
    }
}
