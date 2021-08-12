package stringaddcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TargetNumbers {

    private final List<Integer> targetNumbers;

    private TargetNumbers(List<Integer> targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public static TargetNumbers from(String[] splitTargetNumbersString) {
        List<Integer> targetNumberList = new ArrayList<>();
        for (String targetNumberString : splitTargetNumbersString) {
            int targetNumber = Integer.parseInt(targetNumberString);checkLessThanZero(targetNumber);
            targetNumberList.add(targetNumber);
        }
        return new TargetNumbers(targetNumberList);
    }

    private static void checkLessThanZero(int targetNumber) {
        if (targetNumber < 0) {
            throw new RuntimeException("숫자는 0 이상이어야 합니다.");
        }
    }

    public int sum() {
        return targetNumbers.stream()
                        .mapToInt(targetNumber -> targetNumber)
                        .sum();
    }

    public List<Integer> value() {
        return targetNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetNumbers targetNumbers1 = (TargetNumbers) o;
        return Objects.equals(targetNumbers, targetNumbers1.targetNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetNumbers);
    }

}
