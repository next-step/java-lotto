package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.utils.LottoValidationUtils.INVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

    private LottoNumberGenerator lottoNumberGenerator;
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
        lottoTicket = new LottoTicket(lottoNumberGenerator);
    }

    @Test
    @DisplayName("로또 1번호 개수가 6개인지 확인")
    void lottoTicketSize() {
        lottoNumberGenerator = new LottoNumberGenerator();
        lottoTicket = new LottoTicket(lottoNumberGenerator);
        assertThat(lottoTicket.size()).isEqualTo(6);
        assertThat(lottoTicket.size()).isNotEqualTo(1);
        assertThat(lottoTicket.size()).isNotEqualTo(-1);
        assertThat(lottoTicket.size()).isNotEqualTo(50);
    }

    @Test
    @DisplayName("로또 1장의 6개 번호에 1 ~ 45 외의 숫자가 있으면 Exception 발생")
    void lottoNumberRangeCheck() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    lottoTicket.validateLottoRange(Arrays.asList(-1, 46, 50));
                }).withMessageMatching(INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("임의의 로또 티켓을 만드는 테스트")
    void createManualLottoTicket() {
        lottoNumberGenerator = new LottoNumberGenerator(Arrays.asList(1,2,3,4,5,6));
        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
        assertThat(lottoTicket.getLottoTicket()).contains(1,2,3,4,5,6);
    }

}
