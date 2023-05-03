package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int money, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        int AutoLottoCount = money / LOTTO_PRICE - manualLottos.size();
        for (int i = 0; i < AutoLottoCount; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public Lottos(int money) {
        this(money, new ArrayList<>());
    }

    public Lottos(List<Lotto> manualLottos) {
        this(LOTTO_PRICE * manualLottos.size(), manualLottos);
    }

    public long getFirstRankCount(WinNumbers winNumbers) {
        return lottos.stream()
                .filter(lotto -> lotto.getRank(winNumbers).isFirstRank())
                .count();
    }

    public long getSecondRankCount(WinNumbers winNumbers) {
        return lottos.stream()
                .filter(lotto -> lotto.getRank(winNumbers).isSecondRank())
                .count();
    }

    public long getThirdRankCount(WinNumbers winNumbers) {
        return lottos.stream()
                .filter(lotto -> lotto.getRank(winNumbers).isThirdRank())
                .count();
    }

    public long getFourthRankCount(WinNumbers winNumbers) {
        return lottos.stream()
                .filter(lotto -> lotto.getRank(winNumbers).isFourthRank())
                .count();
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public double getEarningRate(WinNumbers winNumbers) {
        return getTotalPrize(winNumbers) / getTotalPrice();
    }

    private double getTotalPrize(WinNumbers winNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winNumbers))
                .map(Rank::getPrize)
                .reduce(0L, Long::sum);
    }

    private double getTotalPrice() {
        return this.lottos.size() * LOTTO_PRICE;
    }

    public List<Set<Integer>> getNumbers() {
        return this.lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public Boolean isGain(WinNumbers winNumbers) {
        return getEarningRate(winNumbers) > 1;
    }

    public Boolean isLoss(WinNumbers winNumbers) {
        return getEarningRate(winNumbers) < 1;
    }
}
