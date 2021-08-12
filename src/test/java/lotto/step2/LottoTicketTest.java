package lotto.step2;

import lotto.step2.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        lottoTicket = new LottoTicket(LottoMachine.mixLottoNumbers());
    }

    @Test
    @DisplayName("구입한 로또의 숫자의 개수가 6개인지 검증 ")
    void isValidLottoTicketTest() {
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("구입한 로또의 숫자가 중복 되었는지 검증 ")
    void isValidLottoTicketTest2() {
        assertDoesNotThrow(() -> Validation.isValidLotto(lottoTicket.getLottoNumbers()));
    }

    @Test
    @DisplayName("구입한 로또 번호와 당첨 번호 일치하는 개수 테스트")
    void containsNum() {
        LottoTicket ticket = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        LottoTicket winningNumber = LottoTicket.generateWinningNumber(Arrays.asList(
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(15), new LottoNumber(7), new LottoNumber(8)
        ));
        assertThat(ticket.matchWinningNumber(winningNumber)).isEqualTo(2);
    }

}