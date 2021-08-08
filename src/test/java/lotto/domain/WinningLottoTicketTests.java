package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTicketTests {

    @DisplayName("생성 테스트")
    @Test
    void validInputCreateTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1,2,3,4,5,6), LottoNumber.of(7));

        assertThat(winningLottoTicket).isEqualTo(WinningLottoTicket.of(Arrays.asList(1,2,3,4,5,6), LottoNumber.of(7)));
    }

    @DisplayName("contains 테스트")
    @Test
    void containsTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1,2,3,4,5,6), LottoNumber.of(7));

        assertThat(winningLottoTicket.contains(LottoNumber.of(6))).isEqualTo(true);
    }

    @DisplayName("일치하는 갯수를 잘 가져오는지 테스트")
    @Test
    void getMatchCountTest() {
        LottoTicket lottoTicket = LottoTicket.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1,2,3,4,5,6), LottoNumber.of(7));

        assertThat(winningLottoTicket.getCountOfMatch(lottoTicket)).isEqualTo(6);
    }
}
