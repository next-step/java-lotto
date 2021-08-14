package Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Lotto.Money.MONEY_DIVIDE_REMAINDER_ZERO;

public class LottoMachine {

    private NumberGenerator numberGenerator;


    public LottoMachine(NumberGenerator numberGenerator) {

        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLotto(Money money) {
        return IntStream.range(MONEY_DIVIDE_REMAINDER_ZERO, money.getUnit())
                .mapToObj(lotto -> Lotto.of(LotterNumbers.of(numberGenerator.generate())))
                .collect(Collectors.toList());
    }

}




