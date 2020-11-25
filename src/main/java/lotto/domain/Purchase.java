package lotto.domain;

import java.util.function.Function;

public class Purchase {
    public static final int LOTTO_PRICE = 1000;
    private final int manualLottoCount;
    private final int autoLottoCount;

    public Purchase(int money, int manualLottoCount) {
        int totalLottoCount = getLottoCount(money);

        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalLottoCount - manualLottoCount;
        if (this.autoLottoCount < 0) {
            throw new IllegalArgumentException("money and manual lotto count is wrong");
        }
    }

    public static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public Lottos drawLottosByMeans(Function<Integer, Lottos> manualMean, Function<Integer, Lottos> autoMean) {
        Lottos manualLottos = buyLottos(manualMean, manualLottoCount);
        Lottos autoLottos = buyLottos(autoMean, autoLottoCount);

        return manualLottos.concat(autoLottos);
    }

    private Lottos buyLottos(Function<Integer, Lottos> getLottos, int count) {
        Lottos lottos = getLottos.apply(count);
        if (!lottos.checkCount(count)) {
            throw new IllegalArgumentException("sum of lotto count are different with total lotto count");
        }

        return lottos;
    }
}
