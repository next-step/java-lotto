import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
        }
        this.numbers = numbers;
    }

    public int compare(Lotto secondLotto) {
        return secondLotto.contains(numbers);
    }

    private int contains(List<LottoNumber> numbers) {
        return (int) this.numbers.stream().
            filter(n -> numbers.contains(n))
            .count();
    }
}
