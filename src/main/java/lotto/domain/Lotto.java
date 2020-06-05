package lotto.domain;

import java.util.List;

public class Lotto {

    List<Integer> numberList;

    public Lotto() {
    }

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public boolean isContainsNumber(int number) {
        return numberList.contains(number);
    }

    public int checkRightNumberCount(List<Integer> winningNumbers) {

        int rightCount = (int) winningNumbers.stream()
                .filter(winningNumber -> isContainsNumber(winningNumber))
                .count();

        return rightCount;
    }

    public boolean checkRightBonusNumber(int bonusNumber) {
        return numberList.stream()
                .filter(integer -> integer == bonusNumber)
                .findAny()
                .isPresent();
    }

    public Prize getLottoPrize(List<Integer> winningNumbers, int bonusNumber) {
        int rightCount = checkRightNumberCount(winningNumbers);
        boolean isRightBonusNumber = checkRightBonusNumber(bonusNumber);
        return Prize.valueOf(rightCount, isRightBonusNumber);
    }

    public List<Integer> getLottoNumber() {
        return numberList;
    }
}
