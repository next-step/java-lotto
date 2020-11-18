package step3.domain;

import step3.dto.LottoResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMatcher {
    private static final int INCREASE_COUNT = 1;
    private static EnumMap<LottoRank, Integer> result = new EnumMap<LottoRank, Integer>(LottoRank.class);

    private LottoMatcher() {
    }

    public static LottoMatcher ofMatch(Lottos lottos, LastWeekLotto lastWeekLotto) {
        initDefaultMap();

        matchLastWeekLottoNumbers(lottos, lastWeekLotto);
        return new LottoMatcher();
    }

    private static void matchLastWeekLottoNumbers(Lottos lottos, LastWeekLotto lastWeekLottoNums) {
        lottos.matchLastWeekLotto(lastWeekLottoNums)
                .forEach(LottoMatcher::increaseMatchLottoCount);
    }

    private static void initDefaultMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    private static void increaseMatchLottoCount(LottoRank lottoRank) {
        result.put(lottoRank, getLottoCount(lottoRank) + INCREASE_COUNT);
    }

    private static int getLottoCount(LottoRank lottoRank) {
        return result.getOrDefault(lottoRank, 0);
    }


    public List<LottoResultDto> getResult() {
        return Stream.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FORTH, LottoRank.FIFTH)
                .map(lottoRank -> new LottoResultDto(lottoRank, result.get(lottoRank)))
                .collect(Collectors.toList());
    }

    public GameMoney getGamePrize() {
        GameMoney gameMoney = new GameMoney(0);
        for (LottoRank lottoRank : result.keySet()) {
            gameMoney = gameMoney.sum(lottoRank.prize(result.get(lottoRank)));
        }
        return gameMoney;
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
