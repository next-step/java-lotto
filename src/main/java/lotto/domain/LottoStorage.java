package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStorage {

    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;
    private final Map<WinningInformation, Long> result = new HashMap<>();

    public LottoStorage(final List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
        Arrays.stream(WinningInformation.values())
            .filter(wi -> wi != WinningInformation.NO_PRIZE)
            .sorted(Comparator.comparingInt(WinningInformation::getCountOfMatchedNumber))
            .forEach(wi -> this.result.put(wi, 0L));
    }

    private void validateLottos(final List<Lotto> lottos) {
        if (lottos == null || lottos.size() == 0) {
            throw new IllegalStateException("로또를 구매하지 않았습니다.");
        }
    }

    public void matchAllWithWinningLotto(final Lotto winningLotto) {
        this.lottos.stream()
            .map(lotto -> lotto.matchWithWinningLotto(winningLotto))
            .filter(wi -> wi != WinningInformation.NO_PRIZE)
            .forEach(wi -> {
                result.put(wi, result.get(wi) + 1);
            });
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<WinningInformation, Long> getResult() {
        return result;
    }

    public double getProfit() {
        long totalPrizeMoney = this.result.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
            .sum();

        long totalPurchaseMoney = (long) this.lottos.size() * LOTTO_PRICE;

        return totalPrizeMoney / totalPurchaseMoney;
    }
}
