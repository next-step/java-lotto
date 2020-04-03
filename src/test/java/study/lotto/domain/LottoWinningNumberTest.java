package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoWinningNumberTest {
    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        lottoWinningNumber =
                new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
    }

    @DisplayName("당첨번호를 입력한다.")
    @Test
    void setWinningNumber() {
        assertThat(lottoWinningNumber.size()).isEqualTo(6);
    }

    @DisplayName("로또 룰에서 벗어나면 에러 발생")
    @ParameterizedTest
    @MethodSource("provideWinningErrorNumber")
    void outOfRule(List<Integer> winningNumbers, int bonusNumber) {
        assertThatExceptionOfType(
                IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoWinningNumber(winningNumbers, bonusNumber);
                });
    }

    private static Stream<Arguments> provideWinningErrorNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 9),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 9),
                Arguments.of(Arrays.asList(1, 2, 2, 4, 5, 6), 9),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1)
        );
    }

    @DisplayName("당첨번호와 일치하는 숫자의 갯수 반환")
    @ParameterizedTest
    @MethodSource("provideLottoTicket")
    void rand(Lotto lotto, LottoRank expect) {
        assertThat(lottoWinningNumber.rank(lotto))
                .isEqualTo(expect);
    }

    private static Stream<Arguments> provideLottoTicket() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        LottoRank.FIRST),
                Arguments.of(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 45)),
                        LottoRank.SECOND),
                Arguments.of(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        LottoRank.THIRD),
                Arguments.of(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)),
                        LottoRank.FOURTH),
                Arguments.of(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                        LottoRank.FIFTH),
                Arguments.of(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)),
                        LottoRank.MISS),
                Arguments.of(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)),
                        LottoRank.MISS)
        );
    }
}
