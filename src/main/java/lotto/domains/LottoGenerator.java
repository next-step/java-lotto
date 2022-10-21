package lotto.domains;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseByAuto(LottoPurchasedAmount amount) {
        List<Integer> numbers = generateAllLottoNumbers();

        return IntStream.range(0, amount.getAmount() / LOTTO_PRICE)
                .boxed()
                .map(i -> getLotto(numbers))
                .collect(Collectors.toList());
    }

    private List<Integer> generateAllLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.START_NUMBER,
                        LottoNumber.END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private Lotto getLotto(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return new Lotto(numbers
                .stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toList())
        );
    }
}
