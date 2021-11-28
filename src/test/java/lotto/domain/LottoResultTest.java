package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoResultTest {

    static Stream<Arguments> generateArgumentAndMatchCount() {
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.of("1, 2, 3, 4, 5, 6", 7);

        LottoTicket lottoTicket1 = LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket lottoTicket2 = LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoTicket lottoTicket3 = LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)));

        return Stream.of(
            Arguments.of(winnerLottoTicket, lottoTicket1, 6),
            Arguments.of(winnerLottoTicket, lottoTicket2, 5),
            Arguments.of(winnerLottoTicket, lottoTicket3, 5)
        );
    }

    static Stream<Arguments> generateArgumentAndMatchBonus() {
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.of("1, 2, 3, 4, 5, 6", 7);

        LottoTicket lottoTicket1 = LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket lottoTicket2 = LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoTicket lottoTicket3 = LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)));

        return Stream.of(
            Arguments.of(winnerLottoTicket, lottoTicket1, false),
            Arguments.of(winnerLottoTicket, lottoTicket2, true),
            Arguments.of(winnerLottoTicket, lottoTicket3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("generateArgumentAndMatchCount")
    void 당첨번호갯수확인(WinnerLottoTicket winnerLottoTicket, LottoTicket lottoTicket, long count) {
        assertThat(LottoResult.of(winnerLottoTicket, lottoTicket).getMatchCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("generateArgumentAndMatchBonus")
    void 보너스번호일치확인(WinnerLottoTicket winnerLottoTicket, LottoTicket lottoTicket, boolean matchBonus) {
        assertThat(LottoResult.of(winnerLottoTicket, lottoTicket).isMatchBonus()).isEqualTo(matchBonus);
    }
}
