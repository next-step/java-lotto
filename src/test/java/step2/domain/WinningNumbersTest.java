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

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    private static Stream<Arguments> getLottoTickets() {
        List<LottoNumber> nothingMatchNumbers = makeLottoNumbersHelper(11, 12, 13, 14, 15, 16);
        List<LottoNumber> fiveMatchNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 16);
        List<LottoNumber> fiveMatchWithBonus = makeLottoNumbersHelper(1, 2, 3, 4, 15, 45);
        List<LottoNumber> allMatchNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket nothingMatchTicket = new LottoTicket(nothingMatchNumbers);
        LottoTicket fiveMatchTicket = new LottoTicket(fiveMatchNumbers);
        LottoTicket fiveWithBonusMatchTicket = new LottoTicket(fiveMatchWithBonus);
        LottoTicket allMatchLottoTicket = new LottoTicket(allMatchNumbers);

        return Stream.of(
                Arguments.of(nothingMatchTicket, 0),
                Arguments.of(fiveMatchTicket, 5),
                Arguments.of(fiveWithBonusMatchTicket, 5),
                Arguments.of(allMatchLottoTicket, 6));
    }

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 45));
    }

    @ParameterizedTest
    @MethodSource("getLottoTickets")
    void 로또티켓이_몇개맞았는지_확인하기(LottoTicket lottoTicket, int result) {
        int matchAmount = winningNumbers.getMatchAmount(lottoTicket);

        assertThat(matchAmount).isEqualTo(result);
    }
}