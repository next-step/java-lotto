package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @ParameterizedTest
    @DisplayName("각 rank가 나오는지 확인한다.")
    @MethodSource(value = "provideInput")
    void match(String lottoString, LottoRank rank) {
        String testWinningNumbers = "1, 2, 3, 4, 5, 6";
        int bonus = 7;
        WinningLotto winningLotto = new WinningLotto(testWinningNumbers,  bonus);
        Lotto lotto = new Lotto(LottoNumbers.of(lottoString));

        assertThat(winningLotto.match(lotto)).isEqualTo(rank);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", LottoRank.FIRST),
                Arguments.of("2, 3, 4, 5, 6, 7", LottoRank.SECOND),
                Arguments.of("2, 3, 4, 5, 6, 8", LottoRank.THIRD),
                Arguments.of("3, 4, 5, 6, 7, 8", LottoRank.FOURTH),
                Arguments.of("4, 5, 6, 7, 8, 9", LottoRank.FIFTH),
                Arguments.of("10, 11, 12, 13, 14, 15", LottoRank.NONE)
        );
    }
}
