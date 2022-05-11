package lotto.domain;


import java.util.List;

public class Draw {

    private static final int UNIT_PRICE = 1000;

    private final int numberOfLotto;

    private final Lottos lottos;

    private Winnings winnings;

    public Draw(int totalPrice) {
        this.numberOfLotto = totalPrice / UNIT_PRICE;
        this.lottos = new Lottos();
        this.winnings = null;
    }

    public void drawLottos() {
        for (int i = 0; i < numberOfLotto; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public void checkWinnings(Winnings winnings) {
        this.winnings = winnings;
        for (Lotto lotto : lottos()) {
            winnings.countMatchedNumbers(lotto.selectedNumbers());
        }
    }

    public List<Lotto> lottos() {
        return this.lottos.lottos();
    }

    public Winnings winnings() {
        return winnings;
    }
}
