package step2.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @Test
    void 일치하는_개수를_입력하면_상금을_알_수_있다() {
        assertThat(Rank.prizeAmount(6)).isEqualTo(2_000_000_000);
    }

    @ParameterizedTest
    @ValueSource(longs = {
            2,
            7
    })
    void 일치하는_개수가_3개_이상_6개_이하가_아닐경우_예외가_발생한다(long numberOfMatchingNumbers) {
        assertThatThrownBy(() -> Rank.prizeAmount(numberOfMatchingNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치하는 개수가 3 ~ 6 개기어야 합니다.");
    }
}
