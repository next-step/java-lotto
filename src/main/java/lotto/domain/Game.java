package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {

    public static final int PRICE = 1000;
    public static final int NUMBER_OF_LOTTONUMBER = 6;

    private final List<Lottonumber> lottonumbers;

    public Game(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicateNumber(numbers);

        this.lottonumbers = numbers.stream()
                .sorted()
                .map(Lottonumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 로또번호가 필요합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> lottonumberList) {
        Set<Integer> lottonumberSet = new HashSet<>(lottonumberList);

        if (lottonumberSet.size() != lottonumberList.size()) {
            throw new IllegalArgumentException("중복된 로또번호를 사용할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        String[] numbers = lottonumbers.stream()
                .map(Lottonumber::toString)
                .toArray(String[]::new);

        return "[" + String.join(", ", numbers) + "]";
    }
}

