package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_EMPTY_LOTTO;

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
            .forEach(wi -> this.result.put(wi, 0L));
    }

    private void validateLottos(final List<Lotto> lottos) {
        if (lottos == null || lottos.size() == 0) {
            throw new IllegalStateException(ERROR_EMPTY_LOTTO.getMessage());
        }
    }

    public void matchAllWithWinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        this.lottos.stream()
            .map(lotto -> lotto.matchWithWinningLotto(winningLotto, bonusNumber))
            .filter(wi -> wi != WinningInformation.NO_PRIZE)
            .forEach(wi -> {
                result.merge(wi, 1L, Long::sum);
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
