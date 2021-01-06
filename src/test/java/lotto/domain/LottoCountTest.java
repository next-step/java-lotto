package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @DisplayName("로또 수 생성")
    @Test
    void create() {
        LottoCount lottoCount = new LottoCount("15000", "4");
    }

    @DisplayName("수동 로또 수가 숫자가 아닐 경우 예외발생")
    @Test
    void validIsNumberManualCount() {
        assertThatThrownBy(() -> {
            LottoCount lottoCount = new LottoCount("15000", "err");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 수가 양수가 아닐 경우 예외발생")
    @Test
    void validIsPlusManualCount() {
        assertThatThrownBy(() -> {
            new LottoCount("15000", "-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 수가 구매 금액 초과 경우 예외발생")
    @Test
    void validRangeManualCount() {
        assertThatThrownBy(() -> {
            new LottoCount("15000", "16");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}