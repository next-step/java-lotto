package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("당첨된 로또")
class WinningLottoTest {

    public static Stream<Arguments> validLotto() {
        return Stream.of(
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 10, 11, 12))),
                3,
                true
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 11, 12))),
                4,
                false
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 12))),
                5,
                false
            ),
            Arguments.of(
                new WinningLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 10),
                new NormalLotto(LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6))),
                6,
                false
            ));
    }

    @DisplayName("[성공] 일치하는 번호의 개수 & 보너스 번호 일치 여부")
    @ParameterizedTest
    @MethodSource("validLotto")
    public void matchNumberCount(WinningLotto winningLotto, NormalLotto normalLotto, int expectedMatchNumberCount,
        boolean expectedMatchBonusNumber) {
        // given

        // when
        int matchNumberCount = winningLotto.matchNumberCount(normalLotto);
        boolean matchBonusNumber = winningLotto.matchBonusNumber(normalLotto);

        // then
        assertThat(matchNumberCount).isEqualTo(expectedMatchNumberCount);
        assertThat(matchBonusNumber).isEqualTo(expectedMatchBonusNumber);
    }
}
