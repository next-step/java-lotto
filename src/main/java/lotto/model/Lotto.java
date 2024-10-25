package lotto.model;

import lotto.utility.Validator;

import java.util.ArrayList;
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

    public int countMatchingNumber(List<Integer> winningNumbers, int bonusNumber) {
        List<LottoNumber> winningLottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        int matchCount = (int) lotto.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        return checkMatchBonusNumber(matchCount, bonusNumber);
    }

    private int checkMatchBonusNumber(int matchCount, int bonusNumber) {
        if (lotto.contains(new LottoNumber(bonusNumber))) {
            matchCount++;
        }

        return matchCount;
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return lotto.contains(new LottoNumber(bonusNumber));
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < lotto.size(); i++) {
            numbers.add(lotto.get(i).getNumber());
        }

        return numbers;
    }
}
