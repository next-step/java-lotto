package lotto.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchResultTest {

    LottoMatchResult lottoMatchResult;
    Map<LottoResult, Integer> map;

    @Before
    public void setUp() {
        lottoMatchResult = new LottoMatchResult(new Money(1000));

        map = new HashMap<LottoResult, Integer>();
        for (LottoResult result : LottoResult.values()) {
            map.put(result, 0);
        }
    }

    @Test
    public void enum테스트() {
        LottoResult result = LottoResult.valueOf("THREE");
        assertThat(result.matchCount).isEqualTo(3);
        assertThat(LottoResult.THREE.matchCount).isEqualTo(3);
    }

    @Test
    public void enumMap테스트() {
        //3,4,5,6
        LottoResult result = LottoResult.THREE;
        assertThat(map.get(result)).isEqualTo(0);
    }

    @Test
    public void addMatchResult테스트() {
        String matchString = matchNumberToString(3);
        LottoResult result = LottoResult.valueOf(matchString);
        map.put(result, map.get(result) + 1);
        map.put(result, map.get(result) + 1);

        assertThat(map.get(result)).isEqualTo(2);
    }

    @Test
    public void addMatchResult_셋팅되지않은값() {
        String matchString = matchNumberToString(1);
        assertThat(matchString).isEqualTo("NOTHING");

        if (matchString != "NOTHING") {
            LottoResult result = LottoResult.valueOf(matchString);
            assertThat(result).isNull();
        }
    }

    public String matchNumberToString(int matchCount) {
        switch (matchCount) {
            case 3:
                return "THREE";
            case 4:
                return "FOUR";
            case 5:
                return "FIVE";
            case 6:
                return "SIX";
            default:
                return "NOTHING";
        }
    }
}

enum LottoResult {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), SIX(6, 2000000000);
    public final int matchCount;
    public final int money;

    private LottoResult(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }
}