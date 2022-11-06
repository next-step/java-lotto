package lotto.domain;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private int totalQuantity;
    private int manualLottoQuantity;
    private List<Lotto> lottos;

    public Lottos(int amount, int manualLottoQuantity) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("1000원단위로 입력 가능합니다.");
        }

        this.totalQuantity = amount / LOTTO_PRICE;
        this.lottos = new ArrayList<>(totalQuantity);
        this.manualLottoQuantity = manualLottoQuantity;
    }


    public int totalQuantity() {
        return this.totalQuantity;
    }

    public int autoLottoQuantity() {
        return this.totalQuantity - this.manualLottoQuantity;
    }

    public int manualLottoQuantity() {
        return this.manualLottoQuantity;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void saveLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public int getSize() {
        return this.lottos.size();
    }

    public int amount() {
        return this.totalQuantity * LOTTO_PRICE;
    }
}
