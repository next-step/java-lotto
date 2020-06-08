package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.lottoNumbers = new ArrayList<>();
        convertToLottoNumber(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isSatisfied(numbers.size())) {
            throw new IllegalArgumentException("숫자가 부족합니다");
        }
    }

    private void convertToLottoNumber(List<Integer> numbers) {
        for (Integer integer : numbers) {
            lottoNumbers.add(LottoNumber.valueOf(integer));
        }
    }

    private boolean isSatisfied(int count) {
        return count == NUMBER_COUNT;
    }

    public int matches(List<LottoNumber> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean isContainBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
