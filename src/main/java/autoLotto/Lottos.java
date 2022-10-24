package autoLotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();
    private int quantity;

    public Lottos(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }

        this.quantity = amount / LOTTO_PRICE;

        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(Lotto lotto) {
        this.lottos.add(lotto);
        this.quantity +=1;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public int getAmount() {
        return this.quantity * LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getQuantity() {
        return quantity;
    }

}
