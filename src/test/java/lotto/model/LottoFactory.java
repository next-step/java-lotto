package lotto.model;

public class LottoFactory {
    public static Lotto create(Integer... numbers) {
        return new Lotto(LottoNumbers.of(numbers));
    }
}
