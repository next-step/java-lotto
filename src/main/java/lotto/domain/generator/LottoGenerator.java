package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PICK_COUNT = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public static Lottos generateLottosByAmount(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < calculateLottosCount(amount); i++) {
            lottos.add(generate());
        }

        return new Lottos(lottos);
    }

    public static int calculateLottosCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public static Lotto generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_PICK_COUNT);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
