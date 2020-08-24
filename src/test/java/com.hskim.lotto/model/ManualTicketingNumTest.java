package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoTicketingExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ManualTicketingNumTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        ManualTicketingNumber manualTicketingNum = new ManualTicketingNumber(5, new GameNumber(10));

        // when & then
        assertThat(manualTicketingNum).isEqualTo(new ManualTicketingNumber(5, new GameNumber(10)));
    }

    @DisplayName("생성 실패 - 음수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -11, -22, -37})
    void create_유효하지않은수_실패(int ticketNum) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ManualTicketingNumber(ticketNum, new GameNumber(10));
        }).withMessage(LottoTicketingExceptionMessage.NEGATIVE_TICKETING_NUMBER.getMessage());
    }
}
