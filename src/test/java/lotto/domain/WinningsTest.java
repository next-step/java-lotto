package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningsTest {
    private static final Winning FIRST = new Winning(Prize.FIRST, new LottoNumbers(List.of(new LottoNumber(1, 2, 3, 4, 5, 6))));
    private static final Winning SECOND = new Winning(Prize.SECOND, new LottoNumbers(List.of(new LottoNumber(1, 2, 3, 4, 5, 7))));
    private static final Winning THIRD = new Winning(Prize.THIRD, new LottoNumbers(List.of(new LottoNumber(1, 2, 3, 4, 5, 9))));
    private static final Winning FOURTH = new Winning(Prize.FOURTH, new LottoNumbers(List.of(new LottoNumber(1, 2, 3, 4, 10, 11))));
    private static final Winning FIFTH = new Winning(Prize.FIFTH, new LottoNumbers(List.of(new LottoNumber(1, 2, 3, 12, 15, 16))));
    private static final Winning NO_WINNING = new Winning(Prize.NO_PRIZE, new LottoNumbers(List.of(new LottoNumber(11, 12, 13, 14, 15, 16))));
    
    @DisplayName("상금이 있는 당첨결과만 리턴한다.")
    @ParameterizedTest
    @MethodSource("getWinningsSet")
    void getWinnings(Winnings winnings, List<Winning> expected) {
        assertThat(winnings.getWinnings()).hasSameElementsAs(expected);
    }

    @DisplayName("수익금을 리턴한다.")
    @ParameterizedTest
    @MethodSource("incomeSet")
    void income(Winnings winnings, Money expected) {
        assertThat(winnings.income()).isEqualTo(expected);
    }

    private static Stream<Arguments> incomeSet() {
        return Stream.of(
                Arguments.arguments(new Winnings(FIRST, SECOND, THIRD), new Money(2031500000)),
                Arguments.arguments(new Winnings(FOURTH, FIFTH, NO_WINNING), new Money(55000)),
                Arguments.arguments(new Winnings(NO_WINNING, NO_WINNING), Money.ZERO)
        );
    }
    
    private static Stream<Arguments> getWinningsSet() {
        return Stream.of(
                Arguments.arguments(new Winnings(FIRST, SECOND, THIRD), List.of(FIRST, SECOND, THIRD)),
                Arguments.arguments(new Winnings(FIRST, SECOND, THIRD, NO_WINNING), List.of(FIRST, SECOND, THIRD)),
                Arguments.arguments(new Winnings(FIRST, SECOND, THIRD, FOURTH, NO_WINNING, FIFTH, FIFTH, NO_WINNING), List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, FIFTH))
        );
    }
}
