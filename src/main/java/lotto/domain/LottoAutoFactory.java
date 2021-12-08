package lotto.domain;

import java.util.List;

public class LottoAutoFactory implements LottoFactory {

    @Override
    public Lotto newInstance() {
        return new Lotto();
    }

    @Override
    public Lotto newInstance(List<Integer> numbers) {
        return null;
    }
}