package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<WinningPrize, Integer> store = new EnumMap<>(WinningPrize.class);

    private WinningResult() {}

    public static WinningResult init() {

        return new WinningResult();
    }

    public void match(final WinningLottoNumber winningLottoNumber, final List<LottoNumber> lottoNumbers) {

        for (LottoNumber lottoNumber : lottoNumbers) {
            final int match = winningLottoNumber.match(lottoNumber);
            final WinningPrize winningPrice = WinningPrize.from(match);
            alreadyExist(winningPrice);
            notExist(winningPrice);
        }
    }

    private void alreadyExist(final WinningPrize winningPrize) {

        if (store.containsKey(winningPrize)) {
            save(winningPrize, store.get(winningPrize));
        }
    }

    private void notExist(final WinningPrize winningPrize) {

        if (!store.containsKey(winningPrize)) {
            save(winningPrize, 0);
        }
    }

    private void save(final WinningPrize winningPrice, int count) {

        store.put(winningPrice, ++count);
    }

    public BigDecimal sum() {

        BigDecimal result = BigDecimal.ZERO;
        for (WinningPrize winningPrize : this.store.keySet()) {
            final int count = store.get(winningPrize);
            final BigDecimal price = winningPrize.getPrice();
            result = result.add(price.multiply(BigDecimal.valueOf(count)));
        }
        return result;
    }

    public int getResultCount(final WinningPrize winningPrize) {

        final Integer rankCount = store.get(winningPrize);
        if (rankCount == null) {
            return 0;
        }
        return rankCount;
    }
}
