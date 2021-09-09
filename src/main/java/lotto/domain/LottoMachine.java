package lotto.domain;

import java.util.List;
import java.util.Optional;

public class LottoMachine {
    public static final int NUMS_PER_LOTTO = 6;
    public static final int LOTTO_MAX_NUM = 45;
    private final GenerateNumStrategy generateNumStrategy;

    private Lottos lottos;
    private final AffordableLottoCount affordableLottoCount;

    public LottoMachine(int money, GenerateNumStrategy generateNumStrategy) {
        this(money, 0, new Lottos(), generateNumStrategy);
    }

    public LottoMachine(int money, int manualLottoCount, List<Lotto> manualLottoList, GenerateNumStrategy generateNumStrategy) {
        this(money, manualLottoCount, new Lottos(manualLottoList), generateNumStrategy);
    }

    public LottoMachine(AffordableLottoCount affordableLottoCount, List<Lotto> manualLottoList, GenerateNumStrategy generateNumStrategy) {
        this(affordableLottoCount, new Lottos(manualLottoList), generateNumStrategy);
    }

    public LottoMachine(int money, int manualLottoCount, Lottos manualLotto, GenerateNumStrategy generateNumStrategy) {
        this(new AffordableLottoCount(new Money(money), manualLottoCount), manualLotto, generateNumStrategy);
    }

    public LottoMachine(AffordableLottoCount affordableLottoCount, Lottos manualLotto, GenerateNumStrategy generateNumStrategy) {
        this.generateNumStrategy = generateNumStrategy;
        this.affordableLottoCount = affordableLottoCount;
        this.lottos = generateLottos(manualLotto);
    }

    LottoMachine(GenerateNumStrategy generateNumStrategy) {
        this(0, generateNumStrategy);
    }

    LottoMachine(int money) {
        this(money, new AutoGenerateNumsStrategy());
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int calculateBuyableLottos() {
        return affordableLottoCount.calculateBuyableLottos();
    }

    Lottos generateLottos() {
        return generateLottos(new Lottos());
    }

    Lottos generateLottos(Lottos manualInputLotto) {
        if (!Optional.ofNullable(manualInputLotto).isPresent()) {
            manualInputLotto = new Lottos();
        }
        return manualInputLotto.merge(generateNumStrategy.generate(affordableLottoCount.getCountToAutoGenerate(), NUMS_PER_LOTTO));
    }

    WinningResult countWinningPrize(WinningNumber winningNumber) {
        return lottos.checkLottosPrize(winningNumber);
    }

    public int getTotalPrizeMoney(WinningNumber winningNumber) {
        WinningResult winningResult = countWinningPrize(winningNumber);

        return winningResult.getTotalWinningMoney();
    }

    public double getYield(WinningNumber winningNumber) {
        return affordableLottoCount.getYield(getTotalPrizeMoney(winningNumber));
    }

    public WinningResult getWinningResult(WinningNumber winningNumber) {
        return countWinningPrize(winningNumber);
    }
}
