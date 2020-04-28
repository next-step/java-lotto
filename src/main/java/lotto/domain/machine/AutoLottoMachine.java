package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Lotto> buyLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int countOfLotto = money.getCountOfLotto();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        Collections.shuffle(numbers);
        return Lotto.of(numbers.subList(0, 6));
    }
}
