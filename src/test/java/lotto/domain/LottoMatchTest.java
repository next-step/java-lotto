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
        assertThat(LottoMatch.THREE.getWinAmount(2)).isEqualTo(10000);
        assertThat(LottoMatch.FOUR.getWinAmount(2)).isEqualTo(100000);
        assertThat(LottoMatch.FIVE.getWinAmount(2)).isEqualTo(3000000);
        assertThat(LottoMatch.SIX.getWinAmount(2)).isEqualTo(4000000000L);
    }

    @DisplayName("최소 당첨 일치 개수를 얻을 수 있다.")
    @Test
    void canGetMinMatchCount() {
        assertThat(LottoMatch.getMinMatchCount()).isEqualTo(3);
    }
}
