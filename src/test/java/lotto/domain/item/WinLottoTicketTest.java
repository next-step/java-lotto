package lotto.domain.item;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinLottoTicketTest {

//    @DisplayName("당첨 로또를 생성 한다.")
//    @Test
//    public void constructor_success() throws Exception {
//        //given
//        WinLottoTicket winTicket = new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
//        WinLottoTicket winTicket2 = new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
//
//        //then
//        assertThat(winTicket.equals(winTicket2)).isTrue();
//    }
//
//    @DisplayName("당첨 로또의 번호 6개와 추가 보너스 번호 1개가 중복되선 안된다")
//    @Test
//    public void validateBonusNumber_fail() throws Exception {
//        assertThatThrownBy(
//                () -> new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
//        ).isInstanceOf(ValidLottoException.class);
//    }
}
