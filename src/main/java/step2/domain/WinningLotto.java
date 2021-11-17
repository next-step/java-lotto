package step2.domain;

import java.util.List;

public class WinningLotto {
    private static final String REGEX = ", ";

    private Lotto lotto;

    public WinningLotto(String[] splitNumbers) {
        this.lotto = Lotto.of(splitNumbers);
    }

    public static WinningLotto create(String numbers) {
        return new WinningLotto(splitNumbers(numbers));
    }

    public List<Number> getLottoNumbers() {
        return lotto.getLottoNumbers();
    }

    private static String[] splitNumbers(String numbers) {
        return numbers.split(REGEX);
    }
}
