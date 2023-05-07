package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("당첨 번호로부터 일치하는 갯수를 카운트한다.")
    @ParameterizedTest
    @MethodSource("winningNumbersSample")
    public void 로또_숫자_일치_개수_비교(List<Integer> winningNumbers, int rightCount) throws Exception {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 12, 22, 23, 34, 44));
        assertThat(lottoTicket.countMatchingNumbers(new LottoTicket(winningNumbers))).isEqualTo(rightCount);
    }

    static Stream<Arguments> winningNumbersSample() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 15, 18, 56, 59, 41), 1),
                Arguments.of(Arrays.asList(1, 12, 18, 56, 59, 41), 2),
                Arguments.of(Arrays.asList(1, 12, 22, 56, 59, 41), 3),
                Arguments.of(Arrays.asList(1, 12, 22, 23, 59, 41), 4),
                Arguments.of(Arrays.asList(1, 12, 22, 23, 34, 41), 5),
                Arguments.of(Arrays.asList(1, 12, 22, 23, 34, 44), 6)
        );
    }

}
