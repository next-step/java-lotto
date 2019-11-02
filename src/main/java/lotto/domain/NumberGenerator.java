package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NumberGenerator {

    private final int count;
    private final int limitNumber;
    private final List<Integer> totalNumbers;

    public NumberGenerator(final int count, final int limitNumber) {
        this.count = count;
        this.limitNumber = limitNumber;
        this.totalNumbers = new ArrayList<>();
        for (int i = 1; i < limitNumber + 1; i++) {
            totalNumbers.add(i);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(totalNumbers);
        List<Integer> lottoNumbers = new ArrayList<>(totalNumbers.subList(0, count));
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberGenerator that = (NumberGenerator) o;
        return count == that.count &&
                limitNumber == that.limitNumber &&
                Objects.equals(totalNumbers, that.totalNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, limitNumber, totalNumbers);
    }
}
