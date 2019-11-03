package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.helper.LottoHelper.makeLottoNumbersHelper;

class WinLottoTicketTest {

    private WinLottoTicket winLottoTicket;

    private static Stream<Arguments> getLottoTickets() {
        List<LottoNumber> nothingMatchNumbers = makeLottoNumbersHelper(11, 12, 13, 14, 15, 16);
        List<LottoNumber> allMatchNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket nothingMatchTicket = new LottoTicket(nothingMatchNumbers);
        LottoTicket allMatchLottoTicket = new LottoTicket(allMatchNumbers);

        return Stream.of(
                Arguments.of(nothingMatchTicket, 0),
                Arguments.of(allMatchLottoTicket, 6));
    }

    @BeforeEach
    void setUp() {
        winLottoTicket = new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @MethodSource("getLottoTickets")
    void 로또티켓이_몇개맞았는지_확인하기(LottoTicket lottoTicket, int result) {
        int matchAmount = winLottoTicket.getMatchAmount(lottoTicket);

        assertThat(matchAmount).isEqualTo(result);
    }
}