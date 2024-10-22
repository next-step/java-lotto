package lotto.model;

import lotto.utility.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(List<Integer> numbers) {
        Validator.isValidNumbers(numbers);

        this.lotto = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int countMatchingNumber(List<Integer> winningNumbers) {
        List<LottoNumber> winningLottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return (int) lotto.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return lotto.contains(new LottoNumber(bonusNumber));
    }

}
