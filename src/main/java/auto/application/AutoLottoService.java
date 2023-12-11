package auto.application;

import auto.domain.Lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoService {
    public final static int LOTTO_MIN_NUMBER = 1;
    public final static int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> createLottoNumbersList(int lottoCount) {
        return IntStream.range(0, lottoCount)
                        .mapToObj(i -> createLottoNumbers())
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    private Lotto createLottoNumbers() {
        List<Integer> numbers = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
                                         .boxed()
                                         .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }

    public static BigDecimal getReturnRate(int totalAmount, int amount) {
        return BigDecimal.valueOf(totalAmount)
                         .divide(BigDecimal.valueOf(amount));
    }
}
