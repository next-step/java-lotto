package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LotteryMachine {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1_000);
    private static final Integer[] LOTTO_NUMBERS = IntStream.range(1, 46).boxed().toArray(Integer[]::new);

    public static int calculateLottoCount(int amount) {
        BigDecimal purchaseAmount = new BigDecimal(amount);
        return purchaseAmount.divideToIntegralValue(LOTTO_PRICE).intValue();
    }

    public static Lottos issueAutomaticLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Integer[] numbers = LOTTO_NUMBERS.clone();
            Collections.shuffle(Arrays.asList(numbers));
            numbers = Arrays.copyOf(numbers, 6);
            LottoNumbers lottoNumbers = new LottoNumbers(numbers);
            lottoList.add(new Lotto(lottoNumbers));
        }
        return new Lottos(lottoList);
    }

}