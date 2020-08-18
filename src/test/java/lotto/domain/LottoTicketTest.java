package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

    private LottoNumbers lottoNumbers;
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(lottoNumbers);
    }

    @Test
    @DisplayName("로또 1번호 개수가 6개인지 확인")
    void lottoTicketSize() {
        assertThat(lottoTicket.count()).isEqualTo(6);
        assertThat(lottoTicket.count()).isNotEqualTo(1);
        assertThat(lottoTicket.count()).isNotEqualTo(-1);
        assertThat(lottoTicket.count()).isNotEqualTo(50);
    }

    @Test
    @DisplayName("로또 1장의 6개 번호에 1 ~ 45 외의 숫자가 있으면 Exception 발생")
    void test() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    lottoTicket.lottoNumberRangeException(lottoTicket);
                }).withMessageMatching(LottoNumbers.INVALID_LOTTO_NUMBER);
    }

}
