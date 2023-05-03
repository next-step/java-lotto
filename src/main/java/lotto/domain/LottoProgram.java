package lotto.domain;

public class LottoProgram {
    private static final int LOTTO_COST = 1000;
    private int numberOfLotto;
    private Lottos lottos;

    public LottoProgram(int cost, LottoCreatingStrategy lottoCreatingStrategy) {
        this.numberOfLotto = numberOfLotto(validate(cost));
        this.lottos = createLottos(lottoCreatingStrategy);
    }

    private int validate(int cost) {
        if (cost < LOTTO_COST) {
            throw new IllegalArgumentException("구입금액이 로또 한장 가격보다 작을 수 없습니다.");
        }

        return cost;
    }

    private Lottos createLottos(LottoCreatingStrategy lottoCreatingStrategy) {
        return new Lottos(numberOfLotto, lottoCreatingStrategy);
    }

    private int numberOfLotto(int cost) {
        return cost / LOTTO_COST;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }
}
