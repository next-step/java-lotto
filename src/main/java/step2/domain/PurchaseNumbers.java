package step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PurchaseNumbers {

    private final List<List<Number>> numbers;

    private PurchaseNumbers(List<List<Number>> numbers) {
        this.numbers = numbers;
    }

    public static PurchaseNumbers generate(List<List<Integer>> numbers) {

        List<List<Number>> numberList = new ArrayList<>();

        for (List<Integer> number : numbers) {
            validateNumberSize(number);
            validateDuplicate(number);
            numberList.add(integerToNumberList(number));
        }

        return new PurchaseNumbers(numberList);
    }

    private static List<Number> integerToNumberList(List<Integer> number) {
        List<Number> numbers = new ArrayList<>();

        for (Integer integer : number) {
            numbers.add(Number.of(integer));
        }

        return numbers;
    }

    private static void validateDuplicate(List<Integer> number) {
        Set<Integer> set = new HashSet<>(number);

        if (set.size() < 6) {
            throw new IllegalArgumentException("서로 다른 번호를 입력해주세요.");
        }
    }

    private static void validateNumberSize(List<Integer> number) {
        if (number.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public List<Match> countNumber(WinningNumber winningNumber) {
        List<Match> matches = new ArrayList<>();

        for (List<Number> number : numbers) {
            int count = winningNumber.countWithPurchaseNumber(number);
            boolean isBonus = winningNumber.containBonusNumber(number);
            Match match = notFiveMatchesBonusIsFalse(count, isBonus);
            matches.add(match);
        }

        return matches;
    }

    private Match notFiveMatchesBonusIsFalse(int count, boolean isBonus) {
        if (count != 5) {
            return Match.from(count, false);
        }

        return Match.from(count, isBonus);
    }

    public List<List<Number>> purchaseNumbers() {
        return numbers;
    }
}
