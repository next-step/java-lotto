package step2.domain;

import java.util.LinkedHashMap;

public class BaseScore {
    public static LinkedHashMap<ScoreType, Long> getBaseMap() {
        return new LinkedHashMap<ScoreType, Long>() {{
            put(ScoreType.THREE, 0L);
            put(ScoreType.FOUR, 0L);
            put(ScoreType.FIVE, 0L);
            put(ScoreType.FIVE_BONUS, 0L);
            put(ScoreType.SIX, 0L);
        }};
    }
}
