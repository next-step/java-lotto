package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Draw {

    private final int UNIT_PRICE = 1000;

    private final int numberOfLotto;

    private final List<Lotto> lottos;

    public Draw(int totalPrice) {
        this.numberOfLotto = totalPrice / UNIT_PRICE;
        this.lottos = new ArrayList<>();
    }

    public void drawLottos() {
        for (int i = 0; i < numberOfLotto; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
