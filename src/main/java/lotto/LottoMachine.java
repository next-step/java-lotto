package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public List<Lotto> issue(int money) {

        int howManyLottosCanIBuy = money / 1000;

        return IntStream.range(0, howManyLottosCanIBuy)
                .mapToObj(it -> generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto(){
        return new Lotto();
    }

}
