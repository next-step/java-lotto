package lotto.domains;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseByAuto(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("구입할 돈은 음수가 될 수 없습니다.");
        }

        List<Integer> numbers = generateAllLottoNumbers();

        return IntStream.range(0, money / LOTTO_PRICE)
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
