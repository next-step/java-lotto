public class LottoGame {
    private int numberOfLotto;

    public LottoGame(int money) {
        this.numberOfLotto = money / 1000;
    }

    public int getLottoSize() {
        return this.numberOfLotto;
    }
}
