package step2step3.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoInformationTest {

    @MethodSource
    @ParameterizedTest
    void 순위를_반환한다(Set<Integer> lottoNumbers, Rank rank) {
        LottoTicket lottoTicket = LottoTicket.from(new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6)));

        WinningLottoInformation winningLottoInformation = new WinningLottoInformation(7, lottoTicket);

        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(lottoNumbers);
        assertThat(winningLottoInformation.matchedRank(LottoTicket.from(numbersGenerator))).isEqualTo(rank);
    }

    private static Stream<Arguments> 순위를_반환한다() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 8), Rank.THIRD)
        );
    }
}
