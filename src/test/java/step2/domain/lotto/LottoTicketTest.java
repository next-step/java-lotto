package step2.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    LottoTicket winningLottoTicket;
    LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        winningLottoTicket = LottoTicket.from(new LottoNumber(Arrays.asList(1, 2, 4, 8, 16, 32)));
    }

    @Test
    void 객체_생성_시_numbers_길이_확인_오류_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.from(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5))));
    }

    @Test
    void 로또_번호와_당첨_번호_매칭_count_확인_테스트() {
        lottoTicket = LottoTicket.from(new LottoNumber(Arrays.asList(2, 4, 5, 6, 7, 8)));
        assertThat(lottoTicket.findMatchingCount(winningLottoTicket)).isEqualTo(3);
    }
}
