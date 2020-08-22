package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.exception.LottoException.INVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

    private LottoNumbers lottoNumbers;
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers();
        lottoTicket = new LottoTicket(lottoNumbers);
    }

    @Test
    @DisplayName("로또 1번호 개수가 6개인지 확인")
    void lottoTicketSize() {
        lottoNumbers = new LottoNumbers();
        lottoTicket = new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.count()).isEqualTo(6);
        assertThat(lottoTicket.count()).isNotEqualTo(1);
        assertThat(lottoTicket.count()).isNotEqualTo(-1);
        assertThat(lottoTicket.count()).isNotEqualTo(50);
    }

    @Test
    @DisplayName("로또 1장의 6개 번호에 1 ~ 45 외의 숫자가 있으면 Exception 발생")
    void lottoNumberRangeCheck() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    lottoTicket.lottoNumberRangeException(lottoTicket);
                }).withMessageMatching(INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("임의의 로또 티켓을 만드는 테스트")
    void createManualLottoTicket() {
        lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.getLottoTicket()).contains(1,2,3,4,5,6);
    }

}
