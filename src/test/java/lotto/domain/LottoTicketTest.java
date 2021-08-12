package lotto.domain;

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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 단일 상품 테스트")
class LottoTicketTest {

    private WinningLottoTicket winningLottoTicket;

    static Stream<Arguments> provideLottoTickets() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 45}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 44, 45}, 4),
                Arguments.of(new int[]{1, 2, 3, 43, 44, 45}, 3),
                Arguments.of(new int[]{1, 2, 42, 43, 44, 45}, 2),
                Arguments.of(new int[]{1, 41, 42, 43, 44, 45}, 1),
                Arguments.of(new int[]{40, 41, 42, 43, 44, 45}, 0)
        );
    }

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningLottoTicket = new WinningLottoTicket(winningNumbers, 7);
    }

    @ParameterizedTest(name = "{index} : {1}개 일치")
    @MethodSource("provideLottoTickets")
    @DisplayName("로또 추첨 번호와 일치하는 개수 확인")
    void lottoMatchTest(int[] lottoNumbers, int expected) {
        // given
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchCount(winningLottoTicket);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또번호 유효성 검사 Exception 발생")
    void lottoValidationExceptionTest() {
        int[] lottoNumbers = {1, 2, 3, 43, 44};

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("different number size");
    }
}