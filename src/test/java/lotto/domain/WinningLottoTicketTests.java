package lotto.domain;

import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidLottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningLottoTicketTests {

    @DisplayName("생성 테스트")
    @Test
    void validInputCreateTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        assertThat(winningLottoTicket).isEqualTo(WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(7)));
    }

    @DisplayName("contains 테스트")
    @Test
    void containsTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        assertThat(winningLottoTicket.contains(LottoNumber.of(6))).isEqualTo(true);
    }

    @DisplayName("일치하는 갯수를 잘 가져오는지 테스트")
    @Test
    void getMatchRankFirstTest() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("일치하는 갯수 2등을 잘 가져오는지 테스트")
    @Test
    void getMatchRankSecondTest() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoNumber.of(6));

        assertThat(winningLottoTicket.match(lottoTicket)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("보너스 번호를 입력할때 로또에 있는 번호면 exception 테스트")
    @Test
    void InvalidBonusNumberExceptionTest() {

        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatExceptionOfType(InvalidBonusNumberException.class)
                .isThrownBy(() -> {
                    WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoNumber.of(7));
                }).withMessageMatching("보너스 번호가 로또 번호에 존재 합니다.");
    }

}
