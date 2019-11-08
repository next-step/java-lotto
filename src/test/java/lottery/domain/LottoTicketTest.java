package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    void 로또번호에_유효하지않은_값_입력시_예외발생테스트() {
        assertThatIllegalArgumentException().isThrownBy(()-> {
            LottoTicket.of(0, 1, 2, 3, 4, 5);
        });
    }

    @Test
    void 로또번호에_유효하지않은_개수의_숫자_입력시_예외발생테스트() {
        assertThatIllegalArgumentException().isThrownBy(()-> {
            LottoTicket.of(1, 2, 3, 4, 5);
        });
    }

    @Test
    void 로또번호에_같은_값_입력시_예외발생테스트() {
        assertThatIllegalArgumentException().isThrownBy(()-> {
            LottoTicket.of(1, 1, 2, 3, 4, 5);
        });
    }

    @Test
    void 로또번호를_문자열로_리턴테스트() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 같은번호_티켓이_같은지_확인테스트() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6)).isEqualTo(LottoTicket.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 다른번호_티켓이_다른지_확인테스트() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6)).isNotEqualTo(LottoTicket.of(2, 3, 4, 5, 6, 7));
    }

    @Test
    void 당첨번호_확인_테스트() {
        LottoTicket winTicket = LottoTicket.of(1, 2, 3, 4, 5, 6);
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).match(winTicket).size()).isEqualTo(6);
    }
}
