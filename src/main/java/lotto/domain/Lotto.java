package lotto.domain;

import lotto.utils.ValidationChecker;

import java.util.*;
import java.util.stream.Collectors;


public class Lotto {
    private static final int LOTTO_NUMS = 6;
    private static final String DELIMITER = ", ";
    private Set<Number> nums;
    private List<Number> candidateNumbers = Number.initialNumber();

    public Lotto() {
        this.nums = shuffleAndSort();
    }

    public Lotto(List<Integer> inputNums) {
        candidateNumbers = inputNums.stream()
                            .map(number -> Number.of(number)).collect(Collectors.toList());
        this.nums = shuffleAndSort();
    }

    public Lotto(String inputNums) {
        candidateNumbers = splitLotto(inputNums);
        this.nums = shuffleAndSort();
    }

    private List<Number> splitLotto(String nums) {
        ValidationChecker.isEmptyOrNull(nums);
        return Arrays.stream(nums.split(DELIMITER))
                .map(num -> Number.of(num)).collect(Collectors.toList());
    }

    private Set<Number> shuffleAndSort() {
        Collections.shuffle(candidateNumbers);
        Collections.sort(candidateNumbers.stream()
                .limit(LOTTO_NUMS).collect(Collectors.toList()), new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.compareTo(o2);
            }
        });
        return new HashSet<>(candidateNumbers.stream().collect(Collectors.toSet()));
    }

    public long getMatchNums(Lotto lotto) {
        return lotto.nums.stream().
                filter(n -> this.nums.contains(n)).count();
    }

    public Set<Number> getNums() {
        return nums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(nums, lotto.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }
}
