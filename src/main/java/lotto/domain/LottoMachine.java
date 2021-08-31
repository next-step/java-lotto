package lotto.domain;

import java.util.List;

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

    WinningResult countWinningPrize(List<Integer> winningNums, int bonusNum) {
        return lottos.checkLottosPrize(winningNums, bonusNum);
    }

//    WinningResult countWinningPrize(WinningNumber winningNumber) {
//        return null;
////        return lottos.checkLottosPrize(winningNums, bonusNum);
//    }

    public int getTotalPrizeMoney(List<Integer> winningNums, int bonusNum) {
        WinningResult winningResult = countWinningPrize(winningNums, bonusNum);

        return winningResult.getTotalWinningMoney();
    }

    public double getYield(List<Integer> winningNums, int bonusNum) {
        return money.getYield(getTotalPrizeMoney(winningNums, bonusNum));
    }

    public WinningResult getWinningResult(List<Integer> winningNums, int bonusNum) {
        return countWinningPrize(winningNums, bonusNum);
    }
}
