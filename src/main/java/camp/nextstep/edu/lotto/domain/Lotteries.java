package camp.nextstep.edu.lotto.domain;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Lotteries implements Iterable<Lottery> {
    private final List<Lottery> lotteriesList;

    private Lotteries(List<Lottery> lotteriesList) {
        if (lotteriesList == null) {
            throw new IllegalArgumentException("'lotteriesList' must not be null");
        }
        this.lotteriesList = new ArrayList<>(lotteriesList);
    }

    public static Lotteries from(List<Lottery> lotteriesList) {
        return new Lotteries(lotteriesList);
    }

    public Stream<Lottery> stream() {
        return lotteriesList.stream();
    }

    public int size() {
        return lotteriesList.size();
    }

    @Override
    public Iterator<Lottery> iterator() {
        return lotteriesList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Lottery> action) {
        lotteriesList.forEach(action);
    }

    @Override
    public Spliterator<Lottery> spliterator() {
        return lotteriesList.spliterator();
    }

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteriesList=" + lotteriesList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries = (Lotteries) o;
        return lotteriesList.equals(lotteries.lotteriesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteriesList);
    }
}
