package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓은 숫자를 6개 가질 수 있다.")
    void test1() {
        var lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        assertThat(lottoTicket.getLottoNumbers())
                .hasSize(6);
    }

    @Test
    @DisplayName("로또 티켓의 숫자가 6개가 아닐 경우 에러가 발생한다.")
    void test2() {
        assertThatThrownBy(() -> {
            var lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6,7));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 티켓에 들어가는 숫자는 1 이상 45 이하의 숫자다.")
    void test3() {
        assertThatThrownBy(() -> {
            var lottoTicket = new LottoTicket(List.of(0,1,2,3,4,5));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자는 1 이상 45 이하의 숫자이어야 합니다.");
    }
}
