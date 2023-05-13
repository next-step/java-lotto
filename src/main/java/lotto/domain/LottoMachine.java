package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_COST = 1000;
    private static final int NO_MANUAL_LOTTO = 0;
    private Positive numberOfAutoLotto;
    private Positive numberOfManualLotto;

    public LottoMachine(int cost) {
        this(cost, NO_MANUAL_LOTTO);
    }

    public LottoMachine(int cost, int numberOfManualLottos) {
        validate(cost);
        validateManualLottos(cost, numberOfManualLottos);

        this.numberOfAutoLotto = new Positive(calculateNumberOfAutoLotto(cost, numberOfManualLottos));
        this.numberOfManualLotto = new Positive(numberOfManualLottos);
    }

    private void validate(int cost) {
        if (cost < LOTTO_COST) {
            throw new IllegalArgumentException("구입금액이 로또 한장 가격보다 작을 수 없습니다.");
        }
    }

    private void validateManualLottos(int cost, int inputManualLottos) {
        int numberOfLottos = cost / LOTTO_COST;

        if (numberOfLottos < inputManualLottos) {
            throw new IllegalArgumentException("구입한 로또보다 수동 로또 장수가 많을 수 없습니다.");
        }
    }

    public Lottos generateLotto() {
        return createLottos();
    }

    public Lottos generateLotto(List<String> manualNumbers) {
        if (!numberOfManualLotto.isEqual(manualNumbers.size())) {
            throw new IllegalArgumentException("입력한 수동 로또 장수와 수동 로또 번호가 일치하지 않습니다.");
        }
        return createLottos(manualNumbers);
    }

    private Lottos createLottos() {
        return new Lottos(numberOfAutoLotto.getNumber());
    }

    private Lottos createLottos(List<String> manualNumbers) {
        return new Lottos(manualNumbers);
    }

    private int calculateNumberOfAutoLotto(int cost, int numberOfManualLottos) {
        int numberOfLotto = cost / LOTTO_COST;

        return numberOfLotto - numberOfManualLottos;
    }

    public int getNumberOfAutoLottos() {
        return numberOfAutoLotto.getNumber();
    }

    public int getNumberOfManualLottos() {
        return numberOfManualLotto.getNumber();
    }
}
