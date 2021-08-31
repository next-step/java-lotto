package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTicketTest {

    @ParameterizedTest(name = "Prize 생성 [{index}] {2} 등")
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:45:FIRST",
                        "2, 3, 4, 5, 6, 7:1:SECOND",
                        "2, 3, 4, 5, 6, 7:45:THIRD",
                        "3, 4, 5, 6, 7, 8:45:FOURTH",
                        "4, 5, 6, 7, 8, 9:45:FIFTH"},
            delimiter = ':'
    )
    void checkPrize(String testNumbers, int testBonusNumber, Prize resultPrize) {
        // given
        Ticket ticket = Ticket.madeBy(new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));
        Ticket firstPrizeTicket = Ticket.madeBy(new CustomNumbersMaker(testNumbers));
        LottoNumber bonusNumber = LottoNumber.of(testBonusNumber);
        WinningTicket winningTicket = new WinningTicket(firstPrizeTicket, bonusNumber);

        // when
        Prize prize = winningTicket.checkPrize(ticket);

        // then
        assertThat(prize).isEqualTo(resultPrize);
    }

}