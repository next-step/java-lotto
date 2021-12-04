package lotto;

public class LottoMachine {
    private Lottos lottos;

    public LottoMachine(int quantity) {
        this.lottos = new Lottos(quantity);
    }

    public Lottos lottos() {
        return this.lottos;
    }
}
