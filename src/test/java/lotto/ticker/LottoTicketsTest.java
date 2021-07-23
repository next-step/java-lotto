package lotto.ticker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.helper.Generator.generateNumberOfLottoTicket;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 티켓 그룹 클래스 테스트")
class LottoTicketsTest {

    @DisplayName("로또 티켓 그룹은 로또 티켓 여러장으로 초기화 한다.")
    @Test
    void initLottoTickets() {
        assertThat(LottoTickets.from(generateNumberOfLottoTicket(5))).isInstanceOf(LottoTickets.class);
    }

    @DisplayName("들어온 초기화 값이 null 일 경우 예외를 던진다.")
    @Test
    void throwExceptionWhenInitValueIsNull() {
        assertThatThrownBy(() -> LottoTickets.from(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
