package domain;

import spark.utils.CollectionUtils;

import java.util.*;

public class NumberSet {
    private final Set<Integer> numbers;

    private NumberSet() {
        this.numbers = new HashSet<>();
    }

    private NumberSet(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static NumberSet empty() {
        return new NumberSet();
    }

    public static NumberSet fill(Integer ...numbers) {
        return new NumberSet(new HashSet<>(Arrays.asList(numbers)));
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        if(obj.getClass() == getClass()) {
            NumberSet numberSet = (NumberSet) obj;
            return numbers.equals(numberSet.numbers);
        }

        return false;
    }
}
