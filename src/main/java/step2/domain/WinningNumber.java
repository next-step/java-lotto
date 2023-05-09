package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Number> winningNumbers;
    private final Number bonusNumber;

    private WinningNumber(List<Number> winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber generate(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(integerToNumberList(winningNumbers), Number.of(bonusNumber));
    }

    private static List<Number> integerToNumberList(List<Integer> winningNumbers) {
        List<Number> numbers = new ArrayList<>();

        for (Integer integer : winningNumbers) {
            numbers.add(Number.of(integer));
        }

        return numbers;
    }

    public int countWithPurchaseNumber(List<Number> number) {
        int count = 0;

        for (Number winningNumber : winningNumbers) {
            count = count(number, count, winningNumber);
        }

        return count;
    }

    private int count(List<Number> number, int count, Number winningNumber) {
        if (number.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    public boolean containBonusNumber(List<Number> number) {
        return number.contains(bonusNumber);
    }
}
