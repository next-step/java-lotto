package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.WinnerLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerLottoTest {

    @ParameterizedTest
    @DisplayName("당첨된 로또의 갯수가 발급 받은 로또와 실제 번호와 매칭된 결과와 같은 지 테스트")
    @MethodSource("provideLottos")
    void IsNumberOfWinningLottoIsEqualWithRealLottoResult(List<LottoTicket> input, List<Prize> expected) {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        WinnerLotto winnerLotto = new WinnerLotto(input);

        List<Prize> actual = winnerLotto.getPrize(winningNumbers);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new LottoTicket(Arrays.asList(1,2,3,4,5,6)),
                        new LottoTicket(Arrays.asList(1,2,3,4,5,6))),
                        Arrays.asList(Prize.FIRST, Prize.FIRST)),
                Arguments.of(Arrays.asList(
                        new LottoTicket(Arrays.asList(1,2,3,4,5,6)),
                        new LottoTicket(Arrays.asList(1,2,3,4,5,20)),
                        new LottoTicket(Arrays.asList(1,2,3,4,20,30))),
                        Arrays.asList(Prize.FIRST, Prize.SECOND, Prize.THIRD)),
                Arguments.of(Arrays.asList(
                        new LottoTicket(Arrays.asList(11,12,13,14,15,16))),
                        Arrays.asList(Prize.MISS))
        );
    }
}
