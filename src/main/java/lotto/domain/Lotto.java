package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final Numbers numbers;

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto autoGenerate() {
        List<Integer> autoNumbers = new ArrayList<>(Numbers.NUMBER_RANGE);
        Collections.shuffle(autoNumbers);
        autoNumbers = autoNumbers.subList(0, Numbers.CHOICE_COUNT);
        Collections.sort(autoNumbers);
        return new Lotto(new Numbers(autoNumbers));
    }

    public static Lotto manualGenerate(Numbers numbers) {
        List<Integer> manualNumbers = numbers.getValues();
        Collections.sort(manualNumbers);
        return new Lotto(new Numbers(manualNumbers));
    }

    public Numbers numbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
