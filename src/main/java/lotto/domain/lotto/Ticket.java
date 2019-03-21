package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ticket {
    private List<LottoNumber> numbers;

    public Ticket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Ticket(int... numbers) {
        this.numbers = new ArrayList<>();
        for (int i : numbers) {
            this.numbers.add(new LottoNumber(i));
        }
    }

    public void sort() {
        Collections.sort(this.numbers);
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int matchCount(Ticket target) {
        int matchCount = 0;
        for (LottoNumber number : target.numbers) {
            matchCount += count(number);
        }
        return matchCount;
    }

    private int count(LottoNumber number) {
        if (this.contains(number))
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return Objects.equals(numbers, ticket1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
