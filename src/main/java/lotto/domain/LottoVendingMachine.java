package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoVendingMachine {

    private static final LottoVendingMachine DEFAULT_VENDING_MACHINE = new LottoVendingMachine();

    private final LottoCreator lottoCreator;

    private LottoVendingMachine() {
        this(new RandomLottoCreator());
    }

    public LottoVendingMachine(LottoCreator lottoCreator) {
        this.lottoCreator = lottoCreator;
    }

    public static LottoVendingMachine defaultVendingMachine() {
        return DEFAULT_VENDING_MACHINE;
    }

    public List<Lotto> buyLottos(Money money) {
        return Stream.generate(lottoCreator::create)
                     .limit(money.getBuyableLottoSize())
                     .collect(toList());
    }
}
