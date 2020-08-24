package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoValidationUtils.INVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

    private LottoTicket lottoTicket;
    private List<Integer> lottos;


    @BeforeEach
    void setUp() {
        lottos = LottoNumberGenerator.create();
    }

    @Test
    @DisplayName("로또 1번호 개수가 6개인지 확인")
    void lottoTicketSize() {
        List<Integer> lottoNumber = LottoNumberGenerator.getLottoNumbers(lottos);
        lottoTicket = new LottoTicket(lottoNumber);
        assertThat(lottoTicket.size()).isEqualTo(6);
        assertThat(lottoTicket).isNotEqualTo(1);
        assertThat(lottoTicket).isNotEqualTo(-1);
        assertThat(lottoTicket).isNotEqualTo(50);
    }

    @Test
    @DisplayName("로또 1장의 6개 번호에 1 ~ 45 외의 숫자가 있으면 Exception 발생")
    void lottoNumberRangeCheck() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new LottoTicket().validateLottoRange(Arrays.asList(-1, 46, 50));
                }).withMessageMatching(INVALID_LOTTO_NUMBER);
    }

}
