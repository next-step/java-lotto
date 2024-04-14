package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Lottos;
import lotto.NumberGenerator;
import lotto.PurchaseAmount;

public class Customer {

    private final PurchaseAmount amount;
    private final Lottos lottos;

    private Customer(PurchaseAmount amount, Lottos lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public static Customer of(PurchaseAmount amount){
        return new Customer(amount, Lottos.of(new ArrayList<>()));
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void buyManualLotto(Lottos lottos) {
        validNumberOfManualLottos(amount.getManual(), lottos);
        this.lottos.add(lottos);
    }

    public void buyAutoLotto() {
        this.lottos.add(NumberGenerator.generateAutoNumbers(amount.getAuto()));
    }

    private void validNumberOfManualLottos(int amount, Lottos lottos) {
        if (lottos.size() > amount) {
            throw new IllegalArgumentException();
        }
    }
}
