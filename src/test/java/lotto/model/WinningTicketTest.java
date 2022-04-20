package lotto.model;

import lotto.exception.InvalidLottoTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WinningTicketTest {

    private WinningTicket winningTicket;

    @BeforeEach
    void setUp() {
        winningTicket = new WinningTicket(
                Set.of(
                        new LottoNumber(10),
                        new LottoNumber(30),
                        new LottoNumber(16),
                        new LottoNumber(3),
                        new LottoNumber(17),
                        new LottoNumber(45)
                )
        );
    }

    @Test
    @DisplayName("우승 티켓이 정상적으로 생성된다")
    void createWinningTicket() {
        assertThat(winningTicket).isInstanceOfAny(WinningTicket.class);
    }

    @Test
    @DisplayName("로또 넘버가 6개가 아니면 당첨 티켓을 생성할 수 없다")
    void failValidationOfWinningTicket() {
        assertThatThrownBy(() -> new WinningTicket(Set.of(new LottoNumber(2))))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

    @Test
    @DisplayName("일치하는 숫자에 따라 등수를 반환한다")
    void getRank() {
        //given
        LottoTicket lottoTicket = new LottoTicket(
                Set.of(
                        new LottoNumber(30),
                        new LottoNumber(1),
                        new LottoNumber(16),
                        new LottoNumber(7),
                        new LottoNumber(40),
                        new LottoNumber(45)
                )
        );

        //when
        Rank rank = winningTicket.getRank(lottoTicket);

        //then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

}