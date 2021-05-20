package step3.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoVendingMachine {

    private static final LottoVendingMachine instance = new LottoVendingMachine();

    private LottoVendingMachine() { }

    public static LottoVendingMachine getInstance() {
        return instance;
    }

    public List<Lotto> buyLottos(Money money) {
        return Stream.generate(LottoCreator::create)
                     .limit(money.getBuyableLottoSize())
                     .collect(toList());
    }
}
