package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    public static final int PRICE_PER_LOTTO = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int money) {
        checkValidation(money);
        this.lottos = autoLottos(totalCount(money));
    }

    public Lottos(int money, int manualCount) {
        checkValidation(money);
        this.lottos = autoLottos(totalCount(money) - manualCount);
    }

    private void checkValidation(int money) {
        if (money < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("로또를 한 장 이상 구매하세요.");
        }
    }

    private int totalCount(int money) {
        return money / PRICE_PER_LOTTO;
    }

    private List<Lotto> autoLottos(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Lotto()).collect(Collectors.toList());
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public PrizeStatistic countMatch(WinningLotto winningLotto) {
        PrizeStatistic prizeStat = new PrizeStatistic();
        this.lottos.forEach(lotto -> {
            PrizeType prizeType = PrizeType.of(winningLotto.match(lotto), winningLotto.matchBonusNumber(lotto));
            prizeStat.put(prizeType);
        });
        return prizeStat;
    }

    public BigDecimal getInvestment() {
        return new BigDecimal(this.lottos.size() * PRICE_PER_LOTTO);
    }
}
