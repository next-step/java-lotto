package Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {

        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLotto(Money money) {

        return IntStream.range(0, money.getUnit())
                .mapToObj(lotto -> Lotto.of(LotterNumbers.of(numberGenerator.generate())))
                .collect(Collectors.toList());

    }

}




