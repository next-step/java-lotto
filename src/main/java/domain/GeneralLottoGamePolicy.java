package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GeneralLottoGamePolicy implements LottoGamePolicy {
    public static final long FIRST_PRIZE_MATCH_COUNT = 6;
    public static final long SECOND_PRIZE_MATCH_COUNT = 5;
    public static final long THIRD_PRIZE_MATCH_COUNT = 5;
    public static final long FOURTH_PRIZE_MATCH_COUNT = 4;
    public static final long FIFTH_PRIZE_MATCH_COUNT = 3;

    private Map<Long, LottoGamePrize> lottoGamePrizes = new HashMap<>();
    private Map<LottoMatchResult, LottoGamePrize> lottoGamePrizesWithBonus = new HashMap<>();

    public GeneralLottoGamePolicy() {
        lottoGamePrizes.put(FIRST_PRIZE_MATCH_COUNT, LottoGamePrize.FIRST_PRIZE);
        lottoGamePrizesWithBonus.put(LottoMatchResult.of(SECOND_PRIZE_MATCH_COUNT, true), LottoGamePrize.SECOND_PRIZE);
        lottoGamePrizesWithBonus.put(LottoMatchResult.of(THIRD_PRIZE_MATCH_COUNT, false), LottoGamePrize.THIRD_PRIZE);
        lottoGamePrizes.put(FOURTH_PRIZE_MATCH_COUNT, LottoGamePrize.FOURTH_PRIZE);
        lottoGamePrizes.put(FIFTH_PRIZE_MATCH_COUNT, LottoGamePrize.FIFTH_PRIZE);
    }

    @Override
    public LottoGamePrize rank(long matchCount, boolean isMatchBonus) {
        if (matchCount == 5) {
            return lottoGamePrizesWithBonus.get(LottoMatchResult.of(matchCount, isMatchBonus));
        }
        return Optional.ofNullable(lottoGamePrizes.get(matchCount)).orElse(LottoGamePrize.NONE);
    }
}
