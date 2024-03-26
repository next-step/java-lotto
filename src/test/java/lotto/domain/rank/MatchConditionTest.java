package lotto.domain.rank;

import lotto.domain.lotto.LottoMatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchConditionTest {

    @DisplayName("MatchCondition 생성자 테스트")
    @Test
    void constructor() {
        final MatchCondition target = new MatchCondition(5, true);

        assertThat(target).satisfies(condition -> {
            assertThat(condition.matchCount()).isEqualTo(5);
            assertThat(condition.needBonusMatch()).isEqualTo(true);
        });
    }

    @DisplayName("match 함수는 로또 당첨 조건과 동일한지 여부를 검사한다.")
    @Test
    void match() {
        final MatchCondition target = new MatchCondition(5, true);

        assertThat(target.match(new LottoMatchCount(5), true))
                .isTrue();
    }
}
