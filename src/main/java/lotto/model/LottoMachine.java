package lotto.model;

import java.util.List;

public abstract class LottoMachine {

    public List<Lotto> purchase(int quantity) {
        return execute(quantity);
    }

    abstract protected List<Lotto> execute(int quantity);
}
