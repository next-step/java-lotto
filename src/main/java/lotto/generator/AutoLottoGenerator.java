package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    private static final List<Integer> numbers =
            IntStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
            .boxed().collect(Collectors.toList());

    private final Money money;

    public AutoLottoGenerator(int money) {
        this(new Money(money));
    }

    public AutoLottoGenerator(Money money) {
        this.money = money;
    }

    @Override
    public Lottos generate() {
        return new Lottos(randomLottos(money.countOfBuyingLotto()));
    }

    private static List<Lotto> randomLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(numbers);
            lottos.add(new Lotto(new ArrayList<>(numbers.subList(0, 6))));
        }
        return lottos;
    }
}
