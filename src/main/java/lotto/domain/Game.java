package lotto.domain;

import java.util.Arrays;
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

        this.lottonumbers = toLottonumberList(numbers);
    }

    public Game(String input) {
        validateEmptyInput(input);
        List<Integer> numbers = toIntegerList(input);

        validateCount(numbers);
        validateDuplicateNumber(numbers);

        this.lottonumbers = toLottonumberList(numbers);
    }

    private void validateCount(List<Integer> numbers) {
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

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨번호를 입력해 주세요.");
        }
    }

    private List<Integer> toIntegerList(String input) {
        try {
            String[] split = input.split(",");

            return Arrays.stream(split)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static List<Lottonumber> toLottonumberList(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(Lottonumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int countIdenticalLottonumber(Game that) {
        Set<Lottonumber> control = new HashSet<>(this.lottonumbers);
        Set<Lottonumber> compare = new HashSet<>(that.lottonumbers);
        compare.addAll(control);

        int difference = compare.size() - control.size();

        return control.size() - difference;
    }

    @Override
    public String toString() {
        String[] numbers = lottonumbers.stream()
                .map(Lottonumber::toString)
                .toArray(String[]::new);

        return "[" + String.join(", ", numbers) + "]";
    }
}

