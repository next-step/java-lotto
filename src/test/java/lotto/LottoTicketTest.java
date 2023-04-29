package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
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

    @DisplayName("발급받은 로또번호 중 일치여부를 판단해 일치하는 개수를 판단한다")
    @Test
    void matchesLottoTicket() {
        LottoTicket secondRankLottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 45));
        List<Integer> winningLottoTicket = List.of(1, 2, 3, 4, 5, 6);
        int winningCount = secondRankLottoTicket.matchesLottoNumberCount(winningLottoTicket);
        assertThat(winningCount).isEqualTo(5);
    }

    @DisplayName("당첨번호와 보너스번호에 따른 등수를 구한다")
    @ParameterizedTest
    @MethodSource("lottoRank")
    void prize(List<Integer> winningLottoTicket, LottoTicket lottoTicket, LottoNumber bonusNumber, LottoPrize expectedLottoPrize) {
        LottoPrize lottoPrize = lottoTicket.getWinningPrize(winningLottoTicket, bonusNumber);
        assertThat(lottoPrize).isEqualTo(expectedLottoPrize);
    }

    static Stream<Arguments> lottoRank() {
        List<Integer> winningLottoTicket = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(45);
        return Stream.of(
                Arguments.of(winningLottoTicket, LottoTicket.of(List.of(1, 2, 3, 4, 5, 6)), bonusNumber, LottoPrize.RANK1),
                Arguments.of(winningLottoTicket, LottoTicket.of(List.of(1, 2, 3, 4, 5, 45)), bonusNumber, LottoPrize.RANK2),
                Arguments.of(winningLottoTicket, LottoTicket.of(List.of(1, 2, 3, 4, 5, 7)), bonusNumber, LottoPrize.RANK3),
                Arguments.of(winningLottoTicket, LottoTicket.of(List.of(1, 2, 3, 4, 7, 8)), bonusNumber, LottoPrize.RANK4),
                Arguments.of(winningLottoTicket, LottoTicket.of(List.of(1, 2, 3, 7, 8, 9)), bonusNumber, LottoPrize.RANK5),
                Arguments.of(winningLottoTicket, LottoTicket.of(List.of(1, 2, 7, 8, 9, 10)), bonusNumber, LottoPrize.LOST)
        );
    }
}
