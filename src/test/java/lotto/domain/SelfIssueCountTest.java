package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class SelfIssueCountTest {

    @DisplayName("수동 발급 개수 음수 검증")
    @Test
    void validIsPositive() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new SelfIssueCount(-1))
                .withMessage("양수 값만 입력할 수 있습니다: -1");
    }

    @DisplayName("수동 발급 개수 차감")
    @Test
    void decrease() {
        SelfIssueCount count = new SelfIssueCount(1);
        SelfIssueCount decreasedCount = count.decrease();

        assertThat(count.compareTo(decreasedCount)).isEqualTo(1);

    }
}
