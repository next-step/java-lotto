package lotto.model;

import java.util.Collections;
import java.util.List;

public abstract class LottoMachine {
    public static final List<String> EMPTY = Collections.emptyList();
    
    public List<Lotto> purchase(int quantity, List<String> customLotto) {
        return execute(quantity, customLotto);
    }

    abstract protected List<Lotto> execute(int quantity, List<String> customLotto);
}
