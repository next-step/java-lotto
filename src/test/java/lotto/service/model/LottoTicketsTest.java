package lotto.service.model;

import lotto.service.domain.LottoTicket;
import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class LottoTicketsTest {
    @Test
    @DisplayName("로또복권들 갯수 검증")
    void getLottoTicketsCount() {
        List<LottoTicket> result = getTestLottoTicket();
        LottoTickets lottoTickets = LottoTickets.from(getTestLottoTicket());
        assertThat(lottoTickets.getCountOfLottoTickets()).isEqualTo(result.size());
    }

    private List<LottoTicket> getTestLottoTicket() {
        List<LottoNumber> numbers = Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                  LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        return Collections.singletonList(LottoTicket.from(numbers));
    }

    @Test
    @DisplayName("로또복권 정보가 없는 경우 예외 발생")
    void exception() {
        assertThatNullPointerException().isThrownBy(() -> LottoTickets.from(null));
    }
}
