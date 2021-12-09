package lotto.domain;

import java.util.List;

public class LottoAnswerFactory implements LottoFactory {

    @Override
    public Lotto newInstance() {
        return null;
    }

    @Override
    public Lotto newInstance(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
