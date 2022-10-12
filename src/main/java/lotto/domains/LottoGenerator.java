package lotto.domains;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;

    public Lotto purchaseByManual(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Lotto> purchaseByAuto(int money) {
        List<Integer> numbers = IntStream.rangeClosed(LottoNumber.START_NUMBER,
                        LottoNumber.END_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        return IntStream.range(0, money / LOTTO_PRICE)
                .boxed()
                .map(i -> getLotto(numbers))
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
