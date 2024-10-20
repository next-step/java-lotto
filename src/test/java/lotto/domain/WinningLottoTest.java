package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("당첨 결과에 맞는 LottoRank 상수를 반환한다.")
    @ParameterizedTest(name = "결과 = {1}")
    @MethodSource("generateUserLottos")
    void return_LottoRank(Lotto userLotto, LottoRank expected) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        LottoRank actual = winningLotto.createLottoRank(userLotto);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateUserLottos() {
        return Stream.of(
                Arguments.arguments(new Lotto(1, 2, 8, 9, 10, 11), LottoRank.NON_RANKED),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 6), LottoRank.FIRST)
        );
    }
}
