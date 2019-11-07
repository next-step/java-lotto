package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by yusik on 2019/11/08.
 */
public class LotteryNumberTest {

    @DisplayName("유효성 검사 실패: 범위")
    @Test
    void outOfRange() {
        assertThatThrownBy(() -> LotteryNumber.of(50))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("복권 번호의 범위는 \\[\\d+, \\d+\\] 입니다.");
    }

    @DisplayName("문자열 변환")
    @Test
    void numberToString() {

        // given
        String expected = "5";

        // when
        LotteryNumber number = LotteryNumber.of(5);

        // then
        assertThat(number.toString()).isEqualTo(expected);
    }

    @DisplayName("해시코드")
    @Test
    void hashCodeTest() {

        // given
        int expected = 5;

        // when
        LotteryNumber number = LotteryNumber.of(5);

        // then
        assertThat(number.hashCode()).isEqualTo(expected);
    }
}
