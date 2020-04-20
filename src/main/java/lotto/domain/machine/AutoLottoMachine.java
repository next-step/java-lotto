package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {
    private final List<Integer> numbers;

    public AutoLottoMachine() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        this.numbers = numbers;
    }

    @Override
    public List<Lotto> buyLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getCountOfLotto(); i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        Collections.shuffle(numbers);
        return Lotto.of(numbers.subList(0, 6));
    }
}
