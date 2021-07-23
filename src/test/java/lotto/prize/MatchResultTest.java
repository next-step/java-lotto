package lotto.prize;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 결과 클래스 테스트")
class MatchResultTest {

    @DisplayName("당첨 결과는 처음 지불한 금액과 상금 매치 결과를 가지고 초기화 한다.")
    @Test
    void initMatchResult() {
        int payment = 10_000;
        Map<LottoPrize, Integer> matchResult = Collections.emptyMap();

        assertThat(MatchResult.init(payment, matchResult)).isInstanceOf(MatchResult.class);
    }

}
