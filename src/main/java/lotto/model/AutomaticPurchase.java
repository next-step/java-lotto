package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class AutomaticPurchase extends LottoMachine {
    @Override
    public List<Lotto> execute(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(new Lotto(LottoNumberFactory.selectRandomLottoNumbers()));
        }

        return result;
    }
}
