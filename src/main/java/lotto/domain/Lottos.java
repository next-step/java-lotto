package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos ofRandomLottos(Integer purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.ofRandomLottoNumbers();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public static Lottos ofLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getTotalProfit(WinningLotto winningLotto, LottoNumber bonus) {
        return lottos.stream()
                .mapToInt(lotto -> Prize.findPrize(lotto.countMatching(winningLotto), winningLotto, lotto.checkContainNumber(bonus)).getPrize())
                .sum();
    }

    public int getCount(Prize prize, WinningLotto winningLotto, LottoNumber bonus) {
        Long count = lottos.stream()
                .filter(lotto -> Prize.findPrize(lotto.countMatching(winningLotto), winningLotto, lotto.checkContainNumber(bonus)) == prize)
                .count();
        return count.intValue();
    }

    public void mergeLottos(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }
}
