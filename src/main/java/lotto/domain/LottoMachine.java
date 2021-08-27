package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    public static final int NUMS_PER_LOTTO = 6;
    static final int LOTTO_MAX_NUM = 45;
    private GenerateNumStrategy generateNumStrategy;

    private Money money;
    private Lottos lottos;

    LottoMachine(int money, GenerateNumStrategy generateNumStrategy) {
        this.money = new Money(money);
        this.generateNumStrategy = generateNumStrategy;
        this.lottos = generateLottos();
    }

    LottoMachine(GenerateNumStrategy generateNumStrategy) {
        this(0, generateNumStrategy);
    }

    LottoMachine(int money) {
        this(money, new AutoGenerateStrategy());
    }

    int buyableLottos() {
        return money.buyableLottos(LOTTO_PRICE);
    }

    Lottos generateLottos() {
        return generateNumStrategy.generate(buyableLottos(), NUMS_PER_LOTTO);
    }

    WinningResult countLottoPrize(List<Integer> winningNums) {
        return lottos.checkLottoPrize(winningNums);
    }

    public int getTotalPrizeMoney(List<Integer> winningNums) {
        WinningResult winningResult = countLottoPrize(winningNums);

        return winningResult.getTotalPrizeMoney();
    }

    public double getYield(List<Integer> winningNums) {
        return money.getYield(getTotalPrizeMoney(winningNums));
    }
}
