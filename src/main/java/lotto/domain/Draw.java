package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Draw {

    private static final int UNIT_PRICE = 1000;

    private final int numberOfLotto;

    private final List<Lotto> lottos;

    private Winnings winnings;

    public Draw(int totalPrice) {
        this.numberOfLotto = totalPrice / UNIT_PRICE;
        this.lottos = new ArrayList<>();
        this.winnings = null;
    }

    public void drawLottos() {
        for (int i = 0; i < numberOfLotto; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public void checkWinnings(Winnings winnings) {
        this.winnings = winnings;
        for (Lotto lotto : this.lottos) {
            lotto.checkWinnings(winnings);
        }
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Winnings winnings() {
        return winnings;
    }
}
