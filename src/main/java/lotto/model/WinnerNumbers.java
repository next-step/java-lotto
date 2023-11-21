package lotto.model;

import lotto.model.constants.Dividend;

import java.util.Set;

public class WinnerNumbers {
    private final Set<LottoNumberValidate> numbers;
    private final BonusBall bonusBall;

    public WinnerNumbers(LottoNumbers numbers, BonusBall bonusBall) {
        validateDuplicate(numbers, bonusBall);
        this.numbers = numbers.lottoNumbers();
        this.bonusBall = bonusBall;
    }

    public boolean has(LottoNumberValidate number) {
        return numbers.stream()
                .anyMatch(positiveNumber -> positiveNumber.number() == number.number());
    }

    public boolean correctBonus(LottoNumberValidate number) {
        return number.equals(bonusBall.bonus());
    }

    private void validateDuplicate(LottoNumbers numbers, BonusBall bonusBall) {
        if (numbers.lottoNumbers().contains(bonusBall.bonus())) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 중복됩니다. 보너스볼 : " + bonusBall.number());
        }
    }
    public long winnerMoney(Lotto lotto){
        return winResult(lotto).dividendAmount();
    }

    public Dividend winResult(Lotto lotto) {
        int correctCount = 0;
        boolean bonus = false;
        for (LottoNumberValidate lottoNumber : lotto.numbers()) {
            correctCount = getCorrectCount(correctCount, lottoNumber);
            bonus = isBonus(lottoNumber);
        }
        return Dividend.valueOf(correctCount, bonus);
    }

    private int getCorrectCount(int correctCount, LottoNumberValidate lottoNumber) {
        if (has(lottoNumber)) {
            correctCount++;
        }
        return correctCount;
    }

    private boolean isBonus(LottoNumberValidate lottoNumber) {
        return bonusBall.isBonusBall(lottoNumber);
    }
}
