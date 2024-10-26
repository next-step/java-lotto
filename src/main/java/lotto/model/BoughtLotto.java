package lotto.model;

import lotto.utility.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class BoughtLotto {
    private List<LottoNumber> numbers;

    public BoughtLotto(List<Integer> numbers) {
        Validator.isValidNumbers(numbers);

        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int countMatchNumber(WinningLotto winningLotto) {
        return winningLotto.countMatchNumber(numbers);
    }

    public boolean checkContainsBonusNumber(WinningLotto winningLotto) {
        return winningLotto.checkContainsBonusNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

}
