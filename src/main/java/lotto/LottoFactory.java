package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int PRICE_OF_ONE_LOTTO = 1_000;

    private final List<Integer> numbers;

    public LottoFactory() {
        numbers = new ArrayList<>();
        for (int i = Lotto.VALID_MIN_NUMBER; i <= Lotto.VALID_MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public List<Lotto> buyLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (; amount >= PRICE_OF_ONE_LOTTO; amount -= PRICE_OF_ONE_LOTTO) {
            Collections.shuffle(numbers);
            lottos.add(new Lotto(numbers.subList(0, Lotto.VALID_NUMBERS_SIZE)));
        }

        return lottos;
    }
}
