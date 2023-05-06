package lotto.domain;

public class LottoMachine {
    private static final int LOTTO_COST = 1000;
    private int numberOfLotto;

    public LottoMachine(int cost) {
        validate(cost);
        this.numberOfLotto = calculateNumberOfLotto(cost);
    }

    private void validate(int cost) {
        if (cost < LOTTO_COST) {
            throw new IllegalArgumentException("구입금액이 로또 한장 가격보다 작을 수 없습니다.");
        }
    }

    public Lottos create() {
        return createLottos();
    }

    private Lottos createLottos() {
        return new Lottos(numberOfLotto);
    }

    private int calculateNumberOfLotto(int cost) {
        return cost / LOTTO_COST;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

}
