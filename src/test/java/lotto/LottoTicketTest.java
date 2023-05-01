package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @DisplayName("로또 티켓은 6개의 로또번호로 구성된다")
    @Test
    void lottoTicketCount() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 예외 발생")
    @Test
    void checkSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageMatching("로또 티켓은 6개의 로또 번호로만 구성됩니다.");
    }

    @DisplayName("중복된 로또 번호인 경우 예외 발생")
    @Test
    void checkDuplicate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.of(List.of(1, 1, 2, 3, 4, 5)))
                .withMessageMatching("로또 번호는 중복이 허용되지 않습니다.");
    }

    @DisplayName("당첨번호 중 5자리가 같고 보너스번호를 포함하면 2등")
    @Test
    void rank2() {
        List<Integer> winningLottoTicket = List.of(1, 2, 3, 4, 5, 6);
        WinningTicket winningTicket = WinningTicket.of(winningLottoTicket, 45);

        LottoTicket lottoTicket = LottoTicketFixture.of(1, 2, 3, 4, 5, 6);
        LottoPrize actual = lottoTicket.calculatePrize(winningTicket);

        assertThat(actual).isEqualTo(LottoPrize.RANK2);
    }

    @DisplayName("당첨번호와 보너스번호에 따른 등수를 구한다")
    @ParameterizedTest
    @MethodSource("lottoRank")
    void prize(WinningTicket winningTicket, LottoTicket lottoTicket, LottoPrize expectedLottoPrize) {
        LottoPrize lottoPrize = lottoTicket.calculatePrize(winningTicket);
        assertThat(lottoPrize).isEqualTo(expectedLottoPrize);
    }

    static Stream<Arguments> lottoRank() {
        List<Integer> winningLottoTicket = List.of(1, 2, 3, 4, 5, 6);
        WinningTicket winningTicket = WinningTicket.of(winningLottoTicket, 45);
        return Stream.of(
                Arguments.of(winningTicket, LottoTicket.of(List.of(1, 2, 3, 4, 5, 6)), LottoPrize.RANK1),
                Arguments.of(winningTicket, LottoTicket.of(List.of(1, 2, 3, 4, 5, 45)), LottoPrize.RANK2),
                Arguments.of(winningTicket, LottoTicket.of(List.of(1, 2, 3, 4, 5, 7)), LottoPrize.RANK3),
                Arguments.of(winningTicket, LottoTicket.of(List.of(1, 2, 3, 4, 7, 8)), LottoPrize.RANK4),
                Arguments.of(winningTicket, LottoTicket.of(List.of(1, 2, 3, 7, 8, 9)), LottoPrize.RANK5),
                Arguments.of(winningTicket, LottoTicket.of(List.of(1, 2, 7, 8, 9, 10)), LottoPrize.LOST)
        );
    }
}
