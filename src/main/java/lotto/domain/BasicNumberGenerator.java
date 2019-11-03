package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BasicNumberGenerator implements NumberGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_LIMIT = 45;
    private final List<Integer> totalNumbers;

    public BasicNumberGenerator() {
        this.totalNumbers = new ArrayList<>();
        for (int i = 1; i < LOTTO_NUMBER_LIMIT + 1; i++) {
            totalNumbers.add(i);
        }
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(totalNumbers);
        List<Integer> lottoNumbers = new ArrayList<>(totalNumbers.subList(0, LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicNumberGenerator that = (BasicNumberGenerator) o;
        return Objects.equals(totalNumbers, that.totalNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNumbers);
    }
}
