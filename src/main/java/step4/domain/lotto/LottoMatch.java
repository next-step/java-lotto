package step4.domain.lotto;

import step4.domain.money.Cache;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoMatch {

    public static final int WIN_COUNT_ZERO = 0;

    private final Map<LottoRank, Integer> lottoMatch;

    public LottoMatch(Map<LottoRank, Integer> lottoMatch) {
        this.lottoMatch = new EnumMap<>(lottoMatch);
    }

    public Cache sumMoney() {
        return new Cache(lottoMatch.keySet()
            .stream()
            .map(lottoNumber -> lottoNumber.getWinMoney() * lottoMatch.get(lottoNumber))
            .reduce(Integer::sum).orElse(WIN_COUNT_ZERO));
    }

    public Map<LottoRank, Integer> getLottoMatch() {
        return lottoMatch;
    }

    public Integer winCount(LottoRank lottoRank) {
        if (!lottoMatch.containsKey(lottoRank)) {
            return WIN_COUNT_ZERO;
        }

        return lottoMatch.get(lottoRank);
    }

    public Profit calcProfit(int lottoCount) {
        return Profit.calcLottoProfit(sumMoney(), lottoCount);
    }

    @Override
    public String toString() {
        return "ResultOfLottos{" +
            "resultOfLottos=" + lottoMatch +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoMatch that = (LottoMatch) o;
        return Objects.equals(lottoMatch, that.lottoMatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMatch);
    }
}
