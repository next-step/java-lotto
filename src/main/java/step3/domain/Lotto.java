package step3.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        List<Integer> inputList = new ArrayList<Integer>(numbers);
        validation(inputList);
        this.numbers = inputList;
    }

    public static Lotto from(List<Integer> list) {
        return new Lotto(list);
    }

    private void validation(List<Integer> list) {
        if (list.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 길이는 %d개 이어야 합니다.", LOTTO_SIZE));
        }
        if (isDuplicate(list)) {
            throw new IllegalArgumentException("숫자가 중복 되어있습니다.");
        }
        if (isNumbersOutOfBoundary(list)) {
            throw new IllegalArgumentException("유효하지 않는 범위의 숫자입니다.");
        }
    }

    private boolean isNumbersOutOfBoundary(List<Integer> list) {
        for (int num : list) {
            if (num < MINIMUM || num > MAXIMUM) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() != LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        arrangeNumbers();
        return new ArrayList<Integer>(numbers);
    }

    private void arrangeNumbers() {
        this.numbers = numbers.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        arrangeNumbers();
        return this.numbers.toString();
    }
}
