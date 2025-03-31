package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.exception.LottoNumberException;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Lotto {
    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateNumberRange(lottoNumbers);
        validateDuplicates(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
            .sorted()
            .collect(toUnmodifiableList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoNumberException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    private void validateSingleNumberRange(int number) {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new LottoNumberException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoNumberException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public boolean containsNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
