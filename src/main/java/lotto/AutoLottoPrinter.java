package lotto;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoPrinter implements LottoPrinter {
    private static final int INITIAL_CAPACITY = 100;

    @Override
    public List<Lotto> printer(int quantity) {
        List<Lotto> lottos = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < quantity; i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    private static Lotto makeLotto() {
        return new Lotto(LottoNumberGenerator.generator());
    }
}
