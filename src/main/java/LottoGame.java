import java.util.List;
import java.util.Objects;

public class LottoGame {
    private final List<Integer> numbers;

    public LottoGame(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override public String toString() {
        return "LottoGame{" +
                "numbers=" + numbers +
                '}';
    }
}
