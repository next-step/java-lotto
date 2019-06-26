package lotto.model;

import java.util.List;

public class WinningNumbers extends LottoNumbers {


    private List<Number> numbers;
    private Number bonusNumber;

    public WinningNumbers(List<Number> numbers, Number bonusNumber) {
        super(numbers);
        verifyBonusDuplication(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(PickNumbers pickNumbers) {
        long matchCount = this.numbers.stream()
                .filter(pickNumbers::contains)
                .count();

        return LottoRank.match((int) matchCount, hasBonus(pickNumbers));
    }

    private boolean hasBonus(PickNumbers pickNumbers) {
        return pickNumbers.contains(bonusNumber);
    }

    private void verifyBonusDuplication(List<Number> numbers, Number bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 번호가 뽑혀있습니다. ");
        }
    }
}
