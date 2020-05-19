package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMatchTest {

    @DisplayName("일치 개수로 로또 일치 열거를 찾을 수 있다.")
    @ParameterizedTest
    @MethodSource("provideStringsForLottoMatch")
    void canFindLottoMatchByCount(int count, LottoMatch lottoMatch) {
        assertThat(LottoMatch.findByCount(count)).isEqualTo(lottoMatch);
    }

    private static Stream<Arguments> provideStringsForLottoMatch() {
        return Stream.of(
                Arguments.of("3", LottoMatch.THREE),
                Arguments.of("4", LottoMatch.FOUR),
                Arguments.of("5", LottoMatch.FIVE),
                Arguments.of("6", LottoMatch.SIX)
        );
    }

    @DisplayName("유효하지 않은 개수로 로또 일치 열거를 찾을 수 없다.")
    @Test
    void canNotFindLottoMatchByInvalidCount() {
        assertThatThrownBy(() -> LottoMatch.findByCount(1))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("로또 일치 열거는 일치 개수를 얻을 수 있다.")
    @ParameterizedTest
    @MethodSource("provideIntsForCount")
    void canGetCount(int count, int result) {
        assertThat(count).isEqualTo(result);
    }

    private static Stream<Arguments> provideIntsForCount() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE.getCount(), 3),
                Arguments.of(LottoMatch.FOUR.getCount(), 4),
                Arguments.of(LottoMatch.FIVE.getCount(), 5),
                Arguments.of(LottoMatch.SIX.getCount(), 6)
        );
    }

    @DisplayName("로또 일치 열거는 당첨 금액을 얻을 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLongsForAmount")
    void canGetAmount(long amount, long result) {
        assertThat(amount).isEqualTo(result);
    }

    private static Stream<Arguments> provideLongsForAmount() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE.getAmount(), 5000),
                Arguments.of(LottoMatch.FOUR.getAmount(), 50000),
                Arguments.of(LottoMatch.FIVE.getAmount(), 1500000),
                Arguments.of(LottoMatch.SIX.getAmount(), 2000000000)
        );
    }

    @DisplayName("로또 일치 열거는 당첨 건수로 총 당첨 금액을 얻을 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLongsForWinAmount")
    void canGetWinAmount(long winAmount, long result) {
        assertThat(winAmount).isEqualTo(result);
    }

    private static Stream<Arguments> provideLongsForWinAmount() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE.getWinAmount(2), 10000),
                Arguments.of(LottoMatch.FOUR.getWinAmount(2), 100000),
                Arguments.of(LottoMatch.FIVE.getWinAmount(2), 3000000),
                Arguments.of(LottoMatch.SIX.getWinAmount(2), 4000000000L)
        );
    }
}
