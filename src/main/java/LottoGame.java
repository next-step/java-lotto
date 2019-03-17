public class LottoGame {
    private Lottos lottos;

    public LottoGame(int money) {
        int numberOfLotto = money / 1000;
        this.lottos = new Lottos(numberOfLotto);
    }

    public int getLottoSize() {
        return this.lottos.size();
    }
}
