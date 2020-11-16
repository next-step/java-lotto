package step2.domain;

import step2.dto.LottoResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMatcher {
    private static final int INCREASE_COUNT = 1;
    private final EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

    private LottoMatcher(Lottos lottos, List<Integer> lastWeekLottoNums) {
        initDefaultMap();

        matchLastWeekLottoNumbers(lottos, lastWeekLottoNums);
    }

    public static LottoMatcher ofMatch(Lottos lottos, List<Integer> lastWeekLottoNums){
        return new LottoMatcher(lottos , lastWeekLottoNums);
    }

    private void matchLastWeekLottoNumbers(Lottos lottos, List<Integer> lastWeekLottoNums) {
        for (Integer integer : lottos.matchLastWeekLotto(lastWeekLottoNums)) {
            increaseMatchLottoCount(integer);
        }
    }

    private void initDefaultMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    private void increaseMatchLottoCount(int match) {
        result.put(getLottoRank(match), getLottoCount(getLottoRank(match)) + INCREASE_COUNT);
    }

    private LottoRank getLottoRank(int match) {
        return LottoRank.valueOf(match);
    }

    private int getLottoCount(LottoRank lottoRank) {
        return result.getOrDefault(lottoRank, 0);
    }


    public List<LottoResultDto> getResult() {
        return Stream.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FORTH)
                .map(lottoRank -> new LottoResultDto(lottoRank , result.get(lottoRank)))
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
