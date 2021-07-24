package lotto.lotto;

import lotto.helper.Fixture;
import lotto.helper.Generator;
import lotto.money.Money;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;
import lotto.prize.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 정보를 담고 있는 로또 클래스")
public class LottoTest {

    @DisplayName("로또 구매 정보는 구매 금액과 로또 티켓 그룹을 가지고 생성 한다.")
    @Test
    void initLotto() {
        Money payment = Money.from(10_000);
        LottoTickets lottoTickets = Generator.autoLottoTickets(5);

        assertThat(Lotto.of(payment, lottoTickets)).isNotNull();
    }

    @DisplayName("구매 금액이나 로또 그룹이 null 일 경우 예외를 발생한다.")
    @MethodSource
    @ParameterizedTest
    void initLottoException(Money payment, LottoTickets lottoTickets) {
        assertThatThrownBy(() -> Lotto.of(payment, lottoTickets)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initLottoException() {
        return Stream.of(
                Arguments.of(null, Generator.autoLottoTickets(5)),
                Arguments.of(Money.from(1), null),
                Arguments.of(null, null)
        );
    }

    @DisplayName("당첨 번호를 전달 받아 당첨 정보를 반환한다.")
    @Test
    void matchPrize() {
        WinningNumbers winningNumbers = Fixture.winningNumbers2();
        LottoTickets lottoTickets = Fixture.lottoTickets2();

        Lotto lotto = Lotto.of(Money.from(10_000), lottoTickets);
        MatchResult matchResult = lotto.match(winningNumbers);

        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> assertThat(matchResult.matchCount(lottoPrize)).isEqualTo(1));
    }

    @DisplayName("수익률 계산")
    @Test
    void earningRate() {
        WinningNumbers winningNumbers = Fixture.winningNumbers2();
        LottoTickets lottoTickets = Fixture.lottoTickets2();

        int payment = 10_000;
        Lotto lotto = Lotto.of(Money.from(payment), lottoTickets);
        int expectedEarning = Arrays.stream(LottoPrize.values())
                .map(LottoPrize::getPrizeMoney)
                .mapToInt(Money::toInt)
                .sum();

        MatchResult matchResult = lotto.match(winningNumbers);

        assertThat(matchResult.calculateEarningsRate()).isEqualTo((double) expectedEarning / payment);
    }
}
