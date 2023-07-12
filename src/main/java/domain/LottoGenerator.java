package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MONEY_UNIT = 1_000;
    private static final List<Integer> candidates =
            IntStream.range(LottoNumber.START_INCLUSIVE, LottoNumber.END_EXCLUSIVE)
                    .boxed()
                    .collect(Collectors.toList());

    private static Lotto generateSingleLottoAutomatically() {
        Collections.shuffle(candidates);
        return new Lotto(candidates.subList(0, Lotto.REQUIRED_LOTTO_NUMBER_COUNT));
    }

    public static List<Lotto> generateLottosAutomatically(final long money) {
        validate(money);
        final long lottoCount = calculateLottoCount(money);
        final List<Lotto> lottos = new ArrayList<>();

        for (long count = 0; count < lottoCount; count++) {
            lottos.add(generateSingleLottoAutomatically());
        }

        return lottos;
    }

    private static void validate(final long money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("구입금액은 " + MONEY_UNIT + "원 단위여야 합니다.");
        }
    }

    private static long calculateLottoCount(long money) {
        return money / MONEY_UNIT;
    }
}
