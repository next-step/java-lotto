package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this(numbers);
        setBonusNumber(bonusNumber);
    }

    public void setBonusNumber(Integer bonusNumber){
        validateRange(bonusNumber);
        validateDuplicateBonus(bonusNumber, this.getLotto());
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private static void validateDuplicateBonus(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }

    public String compareLotto(Lotto lotto) {
        final int count = match(lotto);
        boolean isBonusNumber = lotto.contains(bonusNumber);
        if (count != 5) {
            isBonusNumber = false;
        }
        return LottoDescription.findLottoHash(count, isBonusNumber);
    }
}
