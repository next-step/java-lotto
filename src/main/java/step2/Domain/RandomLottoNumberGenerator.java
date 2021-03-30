package step2.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_VOLUME = 6;

    private static List<Integer> numberList;
    private Money money;

    public RandomLottoNumberGenerator(Money money) {
        this.money = money;
    }

    static {
        numberList = Stream.iterate(1, n -> n + 1)
                .limit(LOTTO_BOUND)
                .collect(Collectors.toList());
    }

    public List<Lotto> generate() {
        List<Lotto> lottoList = new ArrayList<>();
        PurchasedLottoNumber lottoQuantity = new PurchasedLottoNumber(money);
        for (int i = 0; i < lottoQuantity.getNumber(); i++) {
            Collections.shuffle(numberList);
            lottoList.add(new Lotto(numberList.stream()
                    .limit(LOTTO_VOLUME)
                    .sorted()
                    .map(number -> new LottoNumber(number))
                    .collect(Collectors.toList())));
        }
        return lottoList;
    }
}
