package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoTicketIssuer lottoTicketIssuer;

    @BeforeEach
    void setUp() {
        lottoTicketIssuer = () -> new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
    }

    @DisplayName("입력한 금액만큼의 로또티켓을 생성한다.")
    @ParameterizedTest
    @CsvSource({"14000,14", "3900,3", "200,0"})
    void buy(int amount, int expect) {
        assertThat(new Lotto(amount, lottoTicketIssuer).getQuantity())
                .isEqualTo(expect);
    }

    @DisplayName("당첨번호와 3개 이상 일치하면 당첨된것이다.")
    @ParameterizedTest
    @MethodSource("provideWinning")
    void winning(LottoWinningNumber winningNumber, LottoRank lottoRanks,
                 int winnerCount) {
        Lotto lotto = new Lotto(1000, lottoTicketIssuer);
        LottoResult lottoResult = lotto.setWinningNumber(winningNumber);
        assertThat(lottoResult.getWinner(lottoRanks).size())
                .isEqualTo(winnerCount);
    }

    private static Stream<Arguments> provideWinning() {
        return Stream.of(
                Arguments.of(new LottoWinningNumber(new int[]{1, 2, 3, 4, 5,
                        6}), LottoRank.FIRST, 1),
                Arguments.of(new LottoWinningNumber(new int[]{2, 3, 4, 5, 6,
                        7}), LottoRank.SECOND, 1),
                Arguments.of(new LottoWinningNumber(new int[]{3, 4, 5, 6, 7,
                        8}), LottoRank.THIRD, 1),
                Arguments.of(new LottoWinningNumber(new int[]{4, 5, 6, 7, 8,
                        9}), LottoRank.FOURTH, 1)
        );
    }
}
