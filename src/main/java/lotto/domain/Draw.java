package lotto.domain;


import java.util.List;

public class Draw {

    private static final int UNIT_PRICE = 1000;

    private final NumberOfLottos numberOfAutoLottos;

    private final NumberOfLottos numberOfLottosByHand;

    private final Lottos lottos;

    private Winnings winnings;

    public Draw(int totalPrice, int numberOfByHand) {
        int numberOfAllLotto = totalPrice / UNIT_PRICE;
        this.numberOfLottosByHand = new NumberOfLottos(numberOfByHand);
        this.numberOfAutoLottos = new NumberOfLottos(numberOfAllLotto - numberOfByHand);
        this.lottos = new Lottos();
    }

    public Draw(int totalPrice) {
        this.numberOfAutoLottos = new NumberOfLottos(totalPrice / UNIT_PRICE);
        this.numberOfLottosByHand = new NumberOfLottos(0);
        this.lottos = new Lottos();
    }

    public void drawLottos(List<Integer[]> lottosByHand) {
        if (lottosByHand != null) {
            drawByHand(lottosByHand);
        }
        drawAuto();
    }

    private void drawByHand(List<Integer[]> lottosByHand) {
        for(Integer[] lotto : lottosByHand) {
            this.lottos.add(new Lotto(lotto));
        }
    }

    private void drawAuto() {
        for (int i = 0; i < numberOfAutoLottos.number(); i++) {
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
