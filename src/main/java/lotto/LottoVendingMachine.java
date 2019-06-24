package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {
    private List<Lotto> lottos;

    private final int UNIT_PRICE = 1000;

    public LottoVendingMachine() {
        this.lottos = new ArrayList<>();
    }

    public int howManyLotto(int amount) {
        return amount / UNIT_PRICE;
    }

    public void createLottos(int quantity, LottoGenerator lottoGenerator) {
        for (int i = 0; i < quantity; i++) {
            this.lottos.add(createLotto(lottoGenerator));
        }
    }
    public Lotto createLotto(LottoGenerator lottoGenerator) {
        return new Lotto(lottoGenerator.lottoGeneration());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public int getUnitPrice() {
        return UNIT_PRICE;
    }
}
