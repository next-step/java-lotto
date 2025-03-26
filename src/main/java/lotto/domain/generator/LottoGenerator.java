package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_PICK_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final List<Integer> LOTTO_NUMBER_CACHE = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static Lottos generateLottosByAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            String messageFormat = "거스름돈이 생기지 않는 구입금액을 입력하여야 합니다. 현재 입력 구입금액: %d (로또 1장 금액: %d)";
            throw new IllegalArgumentException(String.format(messageFormat, amount, LOTTO_PRICE));
        }

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
        Collections.shuffle(LOTTO_NUMBER_CACHE);

        List<Integer> lottoNumbers = LOTTO_NUMBER_CACHE.subList(0, LOTTO_PICK_COUNT);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
