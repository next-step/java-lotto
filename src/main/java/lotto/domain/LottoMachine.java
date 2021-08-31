package lotto.domain;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    public static final int NUMS_PER_LOTTO = 6;
    public static final int LOTTO_MAX_NUM = 45;
    private final GenerateNumStrategy generateNumStrategy;

    private Money money;
    private Lottos lottos;

    public LottoMachine(int money, GenerateNumStrategy generateNumStrategy) {
        this.money = new Money(money);
        this.generateNumStrategy = generateNumStrategy;
        this.lottos = generateLottos();
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
        return money.buyableLottos(LOTTO_PRICE);
    }

    Lottos generateLottos() {
        return generateNumStrategy.generate(calculateBuyableLottos(), NUMS_PER_LOTTO);
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
