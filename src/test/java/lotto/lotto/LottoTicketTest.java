package lotto.lotto;

import lotto.number.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("로또 한장애 대한 클래스 테스트")
class LottoTicketTest {

    @DisplayName("로또 한장은 로또 숫자 그룹을 가지고 초기화 한다.")
    @Test
    void initLottoTicket() {
        assertThat(LottoTicket.from(LottoNumberGenerator.generate())).isInstanceOf(LottoTicket.class);
    }

    @DisplayName("초기화 시에 로또 숫자 그룹이 null 일 경우 예외를 던진다.")
    @Test
    void initExceptionWhenLottoTicketIsNull() {
        assertThatThrownBy(() -> LottoTicket.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

}
