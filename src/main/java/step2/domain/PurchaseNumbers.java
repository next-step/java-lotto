package step2.domain;

import java.util.ArrayList;
import java.util.List;

import static step2.domain.MatchFactory.*;

public class PurchaseNumbers {

    private final List<List<Integer>> numbers;

    private PurchaseNumbers(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    public static PurchaseNumbers generate(List<List<Integer>> numbers) {
        return new PurchaseNumbers(numbers);
    }

    public List<Match> countNumber(WinningNumber winningNumber) {
        List<Match> matches = new ArrayList<>();

        for (List<Integer> number : numbers) {
            int count = countWithPurchaseNumber(number, winningNumber.winningNumbers());
            boolean isBonus = containBonusNumber(count, number, winningNumber.bonusNumber());
            Match match = notFiveMatchesBonusIsFalse(count, isBonus);
            matches.add(match);
        }

        return matches;
    }

    private int countWithPurchaseNumber(List<Integer> number, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            count = count(number, count, winningNumber);
        }

        return count;
    }

    private int count(List<Integer> number, int count, Integer winningNumber) {
        if (number.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    private boolean containBonusNumber(int count, List<Integer> number, int bonusNumber) {
        return number.contains(bonusNumber);
    }

    private Match notFiveMatchesBonusIsFalse(int count, boolean isBonus) {
        if (count != 5) {
            return match(count, false);
        }

        return match(count, isBonus);
    }

    public List<List<Integer>> purchaseNumbers() {
        return numbers;
    }
}
