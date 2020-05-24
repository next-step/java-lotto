package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @DisplayName("일치 개수로 로또 일치 열거를 찾을 수 있다.")
    @ParameterizedTest
    @MethodSource("provideStringsForLottoMatch")
    void canFindLottoMatchByCount(int count, boolean isMatchBonus, LottoMatch lottoMatch) {
        assertThat(LottoMatch.findByCount(count, isMatchBonus)).isEqualTo(lottoMatch);
    }

    private static Stream<Arguments> provideStringsForLottoMatch() {
        return Stream.of(
                Arguments.of("3", false, LottoMatch.THREE),
                Arguments.of("4", false, LottoMatch.FOUR),
                Arguments.of("5", false, LottoMatch.FIVE),
                Arguments.of("5", true, LottoMatch.FIVE_BONUS),
                Arguments.of("6", false, LottoMatch.SIX)
        );
    }

    @DisplayName("유효하지 않은 개수로 로또 일치 열거를 찾을 수 없다.")
    @Test
    void canNotFindLottoMatchByInvalidCount() {
        assertThat(LottoMatch.findByCount(1, false)).isNull();
    }

    @DisplayName("로또 일치 열거는 일치 개수를 얻을 수 있다.")
    @Test
    void canGetCount() {
        assertThat(LottoMatch.THREE.getCount()).isEqualTo(3);
        assertThat(LottoMatch.FOUR.getCount()).isEqualTo(4);
        assertThat(LottoMatch.FIVE.getCount()).isEqualTo(5);
        assertThat(LottoMatch.SIX.getCount()).isEqualTo(6);
    }

    @DisplayName("로또 일치 열거는 당첨 금액을 얻을 수 있다.")
    @Test
    void canGetAmount() {
        assertThat(LottoMatch.THREE.getAmount()).isEqualTo(5000);
        assertThat(LottoMatch.FOUR.getAmount()).isEqualTo(50000);
        assertThat(LottoMatch.FIVE.getAmount()).isEqualTo(1500000);
        assertThat(LottoMatch.SIX.getAmount()).isEqualTo(2000000000);
    }

    @DisplayName("로또 일치 열거는 당첨 건수로 총 당첨 금액을 얻을 수 있다.")
    @Test
    void canGetWinAmount() {
        assertThat(LottoMatch.THREE.calculateWinAmount(2)).isEqualTo(10000);
        assertThat(LottoMatch.FOUR.calculateWinAmount(2)).isEqualTo(100000);
        assertThat(LottoMatch.FIVE.calculateWinAmount(2)).isEqualTo(3000000);
        assertThat(LottoMatch.SIX.calculateWinAmount(2)).isEqualTo(4000000000L);
    }

    @DisplayName("최소 당첨 일치 개수를 얻을 수 있다.")
    @Test
    void canGetMinMatchCount() {
        assertThat(LottoMatch.getMinMatchCount()).isEqualTo(3);
    }

    @DisplayName("보너스 문장을 얻을 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLottoMatch")
    void canGetBonusContext(LottoMatch lottoMatch, String result) {
        assertThat(lottoMatch.getBonusContext()).isEqualTo(result);
    }

    private static Stream<Arguments> provideLottoMatch() {
        return Stream.of(
                Arguments.of(LottoMatch.THREE, " "),
                Arguments.of(LottoMatch.FOUR, " "),
                Arguments.of(LottoMatch.FIVE, " "),
                Arguments.of(LottoMatch.FIVE_BONUS, ", 보너스 볼 일치"),
                Arguments.of(LottoMatch.SIX, " ")
        );
    }
}
