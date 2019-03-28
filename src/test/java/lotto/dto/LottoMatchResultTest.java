package lotto.dto;

import lotto.domain.LottoTicket;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchResultTest {
    @Test
    public void enum테스트() {
        LottoMatchType result = LottoMatchType.valueOf("THREE");
        assertThat(result.matchCount).isEqualTo(3);
        assertThat(LottoMatchType.THREE.matchCount).isEqualTo(3);
    }

    @Test
    public void enumMap테스트() {
        LottoMatchResult matchResult = new LottoMatchResult();
        LottoMatchType result = LottoMatchType.THREE;
        assertThat(matchResult.getMatchTable().get(result)).isEqualTo(0);
    }

    @Test
    public void 매치테이블_3개_값확인(){
        LottoMatchResult matchResult = new LottoMatchResult();
        matchResult.match(3);
        matchResult.match(3);
        assertThat(matchResult.getMatchTable().get(LottoMatchType.THREE)).isEqualTo(2);
    }

    @Test
    public void 매치테이블_값확인(){
        LottoMatchResult matchResult = new LottoMatchResult();
        matchResult.match(3);
        matchResult.match(4);
        matchResult.match(5);
        matchResult.match(6);
        assertThat(matchResult.getMatchTable().get(LottoMatchType.THREE)).isEqualTo(1);
        assertThat(matchResult.getMatchTable().get(LottoMatchType.FOUR)).isEqualTo(1);
        assertThat(matchResult.getMatchTable().get(LottoMatchType.FIVE)).isEqualTo(1);
        assertThat(matchResult.getMatchTable().get(LottoMatchType.SIX)).isEqualTo(1);
    }

    @Test
    public void 수익율값테스트_3개_1번매치(){
        LottoMatchResult matchResult = new LottoMatchResult();
        matchResult.match(3);
        //matchResult.match(3);

        assertThat(matchResult.getMatchTable().get(LottoMatchType.THREE)).isEqualTo(1);
        assertThat(matchResult.getLottoMatchRateOfResult(14000)).isEqualTo(0.35);
        assertThat(matchResult.getLottoMatchRateOfResult(5000)).isEqualTo(1);
        assertThat(matchResult.getLottoMatchRateOfResult(50000)).isEqualTo(0.1);
    }

    @Test
    public void 수익율값테스트_3개_5개_1번매치(){
        LottoMatchResult matchResult = new LottoMatchResult();
        matchResult.match(3);

        assertThat(matchResult.getMatchTable().get(LottoMatchType.THREE)).isEqualTo(1);
        assertThat(matchResult.getLottoMatchRateOfResult(1000)).isEqualTo(5);
    }
}