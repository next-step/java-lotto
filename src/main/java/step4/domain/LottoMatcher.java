package step4.domain;

import step4.dto.LottoResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMatcher {
    private static final int INCREASE_COUNT = 1;
    private final EnumMap<LottoRank, Integer> result;

    private LottoMatcher(EnumMap<LottoRank, Integer> result) {
        this.result = result;
    }

    public static LottoMatcher ofMatch(Lottos lottos, LastWeekLotto lastWeekLotto) {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        initDefaultMap(result);

        matchLottoRank(getLottoRanks(lottos, lastWeekLotto), result);
        return new LottoMatcher(result);
    }

    public double getLottoRatio(GameMoney investPrice) {
        return getGamePrize().splitRate(investPrice);
    }

    private GameMoney getGamePrize() {
        GameMoney gameMoney = new GameMoney(0);
        for (LottoRank lottoRank : result.keySet()) {
            gameMoney = gameMoney.sum(lottoRank.prize(result.get(lottoRank)));
        }
        return gameMoney;
    }
    private static void matchLottoRank(List<LottoRank> lottoRanks, EnumMap<LottoRank, Integer> result) {
        lottoRanks.forEach(
                lottoRank -> result.put(lottoRank, getLottoCount(result, lottoRank) + INCREASE_COUNT));
    }

    private static List<LottoRank> getLottoRanks(Lottos lottos, LastWeekLotto lastWeekLotto) {
        return lottos.matchLastWeekLotto(lastWeekLotto);
    }

    private static void initDefaultMap(EnumMap<LottoRank, Integer> lottoResult) {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    private static int getLottoCount(EnumMap<LottoRank, Integer> lottoResult, LottoRank lottoRank) {
        return lottoResult.getOrDefault(lottoRank, 0);
    }


    public List<LottoResultDto> getResult() {
        return Stream.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FORTH, LottoRank.FIFTH)
                .map(lottoRank -> new LottoResultDto(lottoRank, result.get(lottoRank)))
                .collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatcher that = (LottoMatcher) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
