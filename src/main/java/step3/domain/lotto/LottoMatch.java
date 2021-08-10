package step3.domain.lotto;

import step3.domain.money.Cache;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoMatch {

    private static final Integer WIN_COUNT_ZERO = 0;

    private final Map<LottoRank, Integer> lottoMatch;

    public LottoMatch() {
        this(new EnumMap<>(LottoRank.class));
    }

    public LottoMatch(Map<LottoRank, Integer> lottoMatch) {
        this.lottoMatch = lottoMatch;
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

    public void put(LottoRank lottoNumber) {
        lottoMatch.put(lottoNumber, lottoMatch.getOrDefault(lottoNumber, WIN_COUNT_ZERO) + 1);
    }

    public Integer winCount(LottoRank lottoRank) {
        if (!lottoMatch.containsKey(lottoRank)) {
            return WIN_COUNT_ZERO;
        }

        return lottoMatch.get(lottoRank);
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
