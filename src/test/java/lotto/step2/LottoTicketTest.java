package lotto.step2;

import lotto.step2.domain.LottoTicket;
import lotto.step2.domain.Validation;
import lotto.step2.domain.WinningNumber;
import lotto.step2.domain.WinningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        lottoTicket = new LottoTicket();
    }

    @Test
    @DisplayName("구입한 로또의 숫자의 개수가 6개인지 검증 ")
    void isValidLottoTicketTest() {
        assertThat(lottoTicket.getLottoNumber().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("구입한 로또의 숫자가 중복 되었는지 검증 ")
    void isValidLottoTicketTest2() {
        assertDoesNotThrow(()-> Validation.isValidLotto(lottoTicket.getLottoNumber()));
    }

}