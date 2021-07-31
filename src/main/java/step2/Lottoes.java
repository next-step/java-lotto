package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottoes {
    private final List<Lotto> lottoes;

    public Lottoes() {
        this.lottoes = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        this.lottoes.add(lotto);
    }

    public int size() {
        return lottoes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottoes lottoes1 = (Lottoes) o;
        return Objects.equals(lottoes, lottoes1.lottoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoes);
    }

    @Override
    public String toString() {
        return lottoes.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
