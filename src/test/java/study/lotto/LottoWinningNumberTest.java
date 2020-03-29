package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.LottoTicket;
import study.lotto.domain.LottoWinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoWinningNumberTest {
    LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        lottoWinningNumber =
                new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨번호를 입력한다.")
    @Test
    void setWinningNumber() {
        assertThat(lottoWinningNumber.size()).isEqualTo(6);
    }

    @DisplayName("로또 룰에서 벗어나면 에러 발생")
    @ParameterizedTest
    @MethodSource("provideWinningErrorNumber")
    void outOfRule(List<Integer> winningNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoWinningNumber(winningNumbers);
                });
    }

    private static Stream<Arguments> provideWinningErrorNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 2, 4, 5, 6))
        );
    }

    @DisplayName("당첨번호와 일치하는 숫자의 갯수 반환")
    @ParameterizedTest
    @MethodSource("provideLottoTicket")
    void getMatchedNumber(LottoTicket lottoTicket, int expect) {
        assertThat(lottoWinningNumber.getMatches(lottoTicket).size())
                .isEqualTo(expect);
    }

    private static Stream<Arguments> provideLottoTicket() {
        return Stream.of(
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        6),
                Arguments.of(new LottoTicket(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        5),
                Arguments.of(new LottoTicket(Arrays.asList(3, 4, 5, 6, 7, 8)),
                        4),
                Arguments.of(new LottoTicket(Arrays.asList(4, 5, 6, 7, 8, 9)),
                        3),
                Arguments.of(new LottoTicket(Arrays.asList(5, 6, 7, 8, 9, 10)),
                        2),
                Arguments.of(new LottoTicket(Arrays.asList(6, 7, 8, 9, 10, 11)),
                        1),
                Arguments.of(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12))
                        , 0)
        );
    }
}
