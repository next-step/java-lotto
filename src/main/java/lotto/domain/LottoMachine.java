package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    public static final int NUMS_PER_LOTTO = 6;
    public static final int LOTTO_MAX_NUM = 45;
    private final GenerateNumStrategy generateNumStrategy;

    private Money money;
    private Lottos lottos;
    private AffordableLottoCount affordableLottoCount;

//    public LottoMachine(int money, GenerateNumStrategy generateNumStrategy) {
//        this.money = new Money(money);
//        this.generateNumStrategy = generateNumStrategy;
//        this.lottos = generateLottos();
//    }

    public LottoMachine(int money, GenerateNumStrategy generateNumStrategy) {
        this(money, 0, new Lottos(), generateNumStrategy);
    }

    public LottoMachine(int money, int manualLottoCount, List<Lotto> manualLottoList, GenerateNumStrategy generateNumStrategy) {
        this(money, manualLottoCount, new Lottos(manualLottoList), generateNumStrategy);
    }

    public LottoMachine(int money, int manualLottoCount, Lottos manualLotto, GenerateNumStrategy generateNumStrategy) {
        this.money = new Money(money);
        this.generateNumStrategy = generateNumStrategy;
        AffordableLottoCount affordableLottoCount = new AffordableLottoCount(this.money.calculateBuyableLottos(LOTTO_PRICE), manualLottoCount);
        this.lottos = generateLottos2(manualLotto, affordableLottoCount);
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
        return money.calculateBuyableLottos(LOTTO_PRICE);
    }

    Lottos generateLottos() {
        return generateNumStrategy.generate(calculateBuyableLottos(), NUMS_PER_LOTTO);
    }

    Lottos generateLottos2(Lottos manualInputLotto, AffordableLottoCount affordableLottoCount) {
        return manualInputLotto.add(generateNumStrategy.generate(affordableLottoCount.getCountToAutoGenerate(), NUMS_PER_LOTTO));
    }

    WinningResult countWinningPrize(WinningNumber winningNumber) {
        return lottos.checkLottosPrize(winningNumber);
    }

    public int getTotalPrizeMoney(WinningNumber winningNumber) {
        WinningResult winningResult = countWinningPrize(winningNumber);

        return winningResult.getTotalWinningMoney();
    }

    public double getYield(WinningNumber winningNumber) {
        return money.getYield(getTotalPrizeMoney(winningNumber));
    }

    public WinningResult getWinningResult(WinningNumber winningNumber) {
        return countWinningPrize(winningNumber);
    }
}
