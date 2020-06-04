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

    public List<Integer> getLottoNumber() {
        return numberList;
    }
}
