package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBucket {

    private final List<Lotto> lottoes;

    public LottoBucket() {
        this.lottoes = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottoes.add(lotto);
    }

    public void addRandomLotto(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> numbers = lottoNumberGenerator.generateNumbersForLotto();

        this.addLotto(new Lotto(numbers));
    }

    public int size() {
        return lottoes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBucket that = (LottoBucket) o;
        return Objects.equals(lottoes, that.lottoes);
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
