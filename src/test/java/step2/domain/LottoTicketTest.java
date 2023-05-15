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
    public void 로또_숫자_일치_개수_비교(List<Integer> winningNumbers, int matchCount) throws Exception {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 12, 22, 23, 34, 44));
        assertThat(lottoTicket.checkLottoTicket(new LottoTicket(winningNumbers), 0)).isEqualTo(Rank.toPrizeMoney(matchCount));
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

    @DisplayName("2등 당첨 케이스를 테스트한다.")
    @ParameterizedTest
    @MethodSource("secondRankSample")
    public void 로또_2등_당첨(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) throws Exception {
        LottoTicket winningTicket = new LottoTicket(winningNumbers);
        assertThat(new LottoTicket(numbers).checkLottoTicket(winningTicket, bonusNumber)).isEqualTo(Rank.SECOND);
    }

    static Stream<Arguments> secondRankSample() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 12, 13, 14, 27, 45), Arrays.asList(10, 12, 13, 14, 27, 45), 1),
                Arguments.of(Arrays.asList(7, 8, 17, 18, 32, 33), Arrays.asList(7, 8, 17, 29, 32, 33), 18),
                Arguments.of(Arrays.asList(10, 16, 21, 24, 39, 40), Arrays.asList(10, 16, 21, 24, 39, 41), 40)
        );
    }
}
