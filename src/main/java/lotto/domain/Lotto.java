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
//        return numberList.stream().anyMatch(integer -> integer.equals(number));
        return numberList.contains(number);
    }

    public int checkRightNumberCount(List<Integer> winningNumbers) {

//        int rightCount = (int) winningNumbers.stream().filter(this::isContainsNumber).count();

        int rightCount = (int) winningNumbers.stream().filter( winningNumber -> isContainsNumber(winningNumber)).count();

        return rightCount;
    }

    public String getLottoNumber() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        numberList.stream().sorted().forEach(integer -> {
            stringBuffer.append(integer).append(", ");
        });

        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
