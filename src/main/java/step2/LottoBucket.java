package step2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBucket implements Iterable<LottoEntry> {

    private final List<LottoEntry> lottoEntries;

    public LottoBucket() {
        this.lottoEntries = new ArrayList<>();
    }

    public void add(LottoEntry lottoEntry) {
        this.lottoEntries.add(lottoEntry);
    }

    public void add(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> numbers = lottoNumberGenerator.generateNumbersForLotto();

        this.add(new LottoEntry(numbers));
    }

    public int size() {
        return lottoEntries.size();
    }

    public String toOutputString() {
        return lottoEntries.stream()
                .map(LottoEntry::toNumbersString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBucket that = (LottoBucket) o;
        return Objects.equals(lottoEntries, that.lottoEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoEntries);
    }

    @Override
    public Iterator<LottoEntry> iterator() {
        return this.lottoEntries.iterator();
    }
}
