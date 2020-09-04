package cc.oakk.lotto.model;

import cc.oakk.lotto.view.printer.Printable;
import cc.oakk.lotto.view.printer.Printer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class Lotto implements Printable<Lotto> {
    public static final int NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        throwIfNull(numbers);
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야합니다.!", NUMBER_COUNT));
        }

        List<LottoNumber> validatedList = validateNumbers(numbers);

        if (validatedList.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호가 겹쳐서는 안됩니다.");
        }
        this.numbers = Collections.unmodifiableList(validatedList);
    }

    private List<LottoNumber> validateNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public long getMatchingCount(Lotto lotto) {
        return lotto.numbers.stream().filter(numbers::contains).count();
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

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public void print(Printer<Lotto> printer) {
        printer.print(this);
    }
}
