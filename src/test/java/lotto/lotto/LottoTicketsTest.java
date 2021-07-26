package lotto.lotto;

import lotto.helper.Fixture;
import lotto.helper.Generator;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.helper.Generator.lottoTicketList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 티켓 그룹 클래스 테스트")
class LottoTicketsTest {

    @DisplayName("로또 티켓 그룹은 로또 티켓 여러장으로 초기화 한다.")
    @Test
    void initLottoTickets() {
        assertThat(LottoTickets.from(lottoTicketList(5))).isInstanceOf(LottoTickets.class);
    }

    @DisplayName("들어온 초기화 값이 null 일 경우 예외를 던진다.")
    @Test
    void throwExceptionWhenInitValueIsNull() {
        assertThatThrownBy(() -> LottoTickets.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 전달 받으면 결과를 계산하여 등수별로 몇개인지 반환한다.")
    @Test
    void matchWinningNumbers() {
        WinningNumbers winningNumbers = Fixture.winningNumbers();
        LottoTickets lottoTickets = Fixture.lottoTickets();

        Map<LottoPrize, Long> matchResult = lottoTickets.matchWinningNumbers(winningNumbers);

        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> assertThat(matchResult.get(lottoPrize)).isEqualTo(1));
    }

    @DisplayName("로또 티켓 그룹이 또 다른 로또 티켓 그룹을 전달 받아서 하나의 로또 티켓을 이룬다.")
    @MethodSource
    @ParameterizedTest
    void merge(LottoTickets lottoTickets, LottoTickets anotherLottoTickets, int expectedSize) {
        lottoTickets.merge(anotherLottoTickets);

        assertThat(lottoTickets.size()).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> merge() {
        return Stream.of(
                Arguments.of(Generator.autoLottoTickets(5), Generator.autoLottoTickets(5), 10),
                Arguments.of(Generator.autoLottoTickets(5), Generator.autoLottoTickets(0), 5)
        );
    }
}
