package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.ErrorCode;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 길이 확인")
    void lottoTicket_shouldBeSix() {
        // success
        Set<LottoNumber> successLottoNumber = new HashSet<>();
        for(int i = 1; i <= 6; i++) {
            successLottoNumber.add(new LottoNumber(i));
        }
        assertThat(new LottoTicket(successLottoNumber)).isInstanceOf(LottoTicket.class);


        // failed
        Set<LottoNumber> failLottoNumber = new HashSet<>();
        for(int i = 1; i <= 4; i++) {
            successLottoNumber.add(new LottoNumber(i));
        }

        assertThatThrownBy(()->new LottoTicket(failLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMEBRS_LENGTH.getErrorMessage());
    }

}
