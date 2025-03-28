package step3.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.lotto.exception.LottoTicketException;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 번호 6개로 생성된 올바른 로또 티켓")
    void given6LottoNumbers_whenCreateLottoTicket_thenSuccess() {
        // given
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);

        // when & then
        assertDoesNotThrow(() -> new LottoTicket(
            List.of(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6)));
    }

    @Test
    @DisplayName("로또 번호 7개로 생성된 유효하지 않은 로또 티켓")
    void given7LottoNumbers_whenCreateLottoTicket_thenSuccess() {
        // given
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);
        LottoNumber lottoNumber7 = new LottoNumber(7);

        // when
        assertThatThrownBy(() -> new LottoTicket(
            List.of(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6, lottoNumber7)))

            // then
            .isExactlyInstanceOf(LottoTicketException.class);
    }

    @Test
    @DisplayName("로또 번호 5개로 생성된 유효하지 않은 로또 티켓")
    void given5LottoNumbers_whenCreateLottoTicket_thenSuccess() {
        // given
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);

        // when
        assertThatThrownBy(
            () -> new LottoTicket(List.of(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5)))

            // then
            .isExactlyInstanceOf(LottoTicketException.class);
    }

    @Test
    @DisplayName("로또 번호 6개를 문자열로 입력받아 생성된 로또 티켓")
    void givenString6LottoNumbers_whenCreateLottoTicket_thenSuccess() {
        // given
        String lottoNumbers = "1, 2, 3, 4, 5, 6";

        // when & then
        assertDoesNotThrow(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호 7개를 문자열로 입력받아서 생성된 유효하지 않은 로또 티켓")
    void givenString7LottoNumbers_whenCreateLottoTicket_thenSuccess() {
        // given
        String lottoNumbers = "1, 2, 3, 4, 5, 6, 7";

        // when
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))

            // then
            .isExactlyInstanceOf(LottoTicketException.class);
    }

    @Test
    @DisplayName("로또 번호 5개를 문자열로 입력받아서 생성된 유효하지 않은 로또 티켓")
    void givenString5LottoNumbers_whenCreateLottoTicket_thenSuccess() {
        // given
        String lottoNumbers = "1, 2, 3, 4, 5";

        // when
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))

            // then
            .isExactlyInstanceOf(LottoTicketException.class);
    }

    @Test
    @DisplayName("당첨 X 테스트 #1")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount0_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("7, 8, 9, 10, 11, 12");
        LottoNumber bonusLottoNumber = new LottoNumber(1);

        // when
        assertThat(lottoTicket.scratch(lastWeekWinningTicket, bonusLottoNumber))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.NONE0));
    }

    @Test
    @DisplayName("당첨 X 테스트 #2")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount1_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("6, 7, 8, 9, 10, 11");
        LottoNumber bonusLottoNumber = new LottoNumber(1);

        // when
        assertThat(lottoTicket.matchLottoNumbers(lastWeekWinningTicket))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.NONE1));
    }

    @Test
    @DisplayName("당첨 X 테스트 #3")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount2_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("5, 6, 7, 8, 9, 10");
        LottoNumber bonusLottoNumber = new LottoNumber(1);

        // when
        assertThat(lottoTicket.matchLottoNumbers(lastWeekWinningTicket))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.NONE2));
    }


    @Test
    @DisplayName("5등 당첨 테스트")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount3_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("4, 5, 6, 7, 8, 9");
        LottoNumber bonusLottoNumber = new LottoNumber(1);

        // when
        assertThat(lottoTicket.scratch(lastWeekWinningTicket, bonusLottoNumber))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.FIFTH));
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount4_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("3, 4, 5, 6, 7, 8");
        LottoNumber bonusLottoNumber = new LottoNumber(1);

        // when
        assertThat(lottoTicket.scratch(lastWeekWinningTicket, bonusLottoNumber))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.FOURTH));
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount5_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("2, 3, 4, 5, 6, 7");
        LottoNumber bonusLottoNumber = new LottoNumber(8);

        // when
        assertThat(lottoTicket.scratch(lastWeekWinningTicket, bonusLottoNumber))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.THIRD));
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount5AndBonusNumber_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("2, 3, 4, 5, 6, 7");
        LottoNumber bonusLottoNumber = new LottoNumber(1);

        // when
        assertThat(lottoTicket.scratch(lastWeekWinningTicket, bonusLottoNumber))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.SECOND));
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount6_thenSuccess() {
        // given
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber bonusLottoNumber = new LottoNumber(7);

        // when
        assertThat(lottoTicket.scratch(lastWeekWinningTicket, bonusLottoNumber))

            // then
            .isEqualTo(LottoPrize.matchCountOf(LottoPrize.FIRST));
    }

}
