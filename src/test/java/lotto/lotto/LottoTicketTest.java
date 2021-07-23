package lotto.lotto;

import lotto.helper.Generator;
import lotto.number.LottoNumberGenerator;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.helper.Generator.winningNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("로또 한장애 대한 클래스 테스트")
class LottoTicketTest {

    @DisplayName("로또 한장은 로또 숫자 그룹을 가지고 초기화 한다.")
    @Test
    void initLottoTicket() {
        assertThat(LottoTicket.from(LottoNumberGenerator.generate())).isInstanceOf(LottoTicket.class);
    }

    @DisplayName("초기화 시에 로또 숫자 그룹이 null 일 경우 예외를 던진다.")
    @Test
    void initExceptionWhenLottoTicketIsNull() {
        assertThatThrownBy(() -> LottoTicket.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 가지고 등수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void matchPrize(LottoTicket lottoTicket, LottoPrize expectedLottoPrize) {
        WinningNumbers winningNumbers = winningNumbers(5, 10, 15, 20, 25, 30);

        assertThat(lottoTicket.matchPrize(winningNumbers)).isEqualTo(expectedLottoPrize);
    }

    private static Stream<Arguments> matchPrize() {
        return Stream.of(
                Arguments.of(Generator.lottoTicket(5, 10, 15, 20, 25, 30), LottoPrize.FIRST),
                Arguments.of(Generator.lottoTicket(5, 10, 15, 20, 25, 31), LottoPrize.SECOND),
                Arguments.of(Generator.lottoTicket(5, 10, 15, 20, 26, 31), LottoPrize.THIRD),
                Arguments.of(Generator.lottoTicket(5, 10, 15, 21, 26, 31), LottoPrize.FOURTH),
                Arguments.of(Generator.lottoTicket(5, 10, 16, 21, 26, 31), LottoPrize.NONE),
                Arguments.of(Generator.lottoTicket(5, 11, 16, 21, 26, 31), LottoPrize.NONE),
                Arguments.of(Generator.lottoTicket(6, 11, 16, 21, 26, 31), LottoPrize.NONE)
        );
    }
}
