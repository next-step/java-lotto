package lotto.model;

public class LottoFactory {
    public static Lotto create(Integer... numbers) {
        return LottoNumberFactory.of(numbers);
    }
}
