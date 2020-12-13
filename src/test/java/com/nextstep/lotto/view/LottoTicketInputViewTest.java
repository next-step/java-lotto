package com.nextstep.lotto.view;

import com.nextstep.lotto.view.exceptions.InvalidLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.nextstep.lotto.domain.LottoTicketFixtures.LOTTO_TICKET_123456;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketInputViewTest {
    @DisplayName("로또에 당첨 결과 확인에 사용할 당첨 티켓을 반환할 수 있다.")
    @Test
    void createTest() {
        LottoTicketInputView inputView = new LottoTicketInputView("1, 2, 3, 4, 5, 6");

        assertThat(inputView.parseToLottoTicket()).isEqualTo(LOTTO_TICKET_123456);
    }

    @DisplayName("잘못된 문자열을 인자로 받은 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1, 2, 3", "1,2, 3,4, 5,6"})
    void createFailTest(String invalidValue) {
        assertThatThrownBy(() -> new LottoTicketInputView(invalidValue))
                .isInstanceOf(InvalidLottoNumbersException.class);
    }
}
