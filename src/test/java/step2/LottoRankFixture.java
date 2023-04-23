package step2;

import java.util.Map;

import static step2.LottoRank.MATCH_FIVE;
import static step2.LottoRank.MATCH_FOUR;
import static step2.LottoRank.MATCH_SIX;
import static step2.LottoRank.MATCH_THREE;

public class LottoRankFixture {

    public static Map<LottoRank, Integer> _3개_당첨_3명() {
        return Map.of(
                MATCH_THREE, 3,
                MATCH_FOUR, 0,
                MATCH_FIVE, 0,
                MATCH_SIX, 0
        );
    }

    public static Map<LottoRank, Integer> _4개_당첨_3명() {
        return Map.of(
                MATCH_THREE, 0,
                MATCH_FOUR, 3,
                MATCH_FIVE, 0,
                MATCH_SIX, 0
        );
    }


    public static Map<LottoRank, Integer> _5개_당첨_3명() {
        return Map.of(
                MATCH_THREE, 0,
                MATCH_FOUR, 0,
                MATCH_FIVE, 3,
                MATCH_SIX, 0
        );
    }

    public static Map<LottoRank, Integer> _6개_당첨_3명() {
        return Map.of(
                MATCH_THREE, 0,
                MATCH_FOUR, 0,
                MATCH_FIVE, 0,
                MATCH_SIX, 3
        );
    }

    public static Map<LottoRank, Integer> _3개_당첨_2명_4개_당첨_1명() {
        return Map.of(
                MATCH_THREE, 2,
                MATCH_FOUR, 1,
                MATCH_FIVE, 0,
                MATCH_SIX, 0
        );
    }
}
