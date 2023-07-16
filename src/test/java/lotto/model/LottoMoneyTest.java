package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {

    @Test
    void 돈_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoMoney(1000));
    }

    @Test
    void 돈_객체_값_반환_성공() {
        // given, when, then
        assertThat(new LottoMoney(1000).getValue()).isEqualTo(1000);
    }

    @Test
    void 로또_가격_이하의_돈_객체_생성시_예외_발생() {
        // given, when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMoney(999));
        assertThat(exception).hasMessage("로또를 구입하기에 돈이 부족합니다. 로또는 한 장에 " + 1000 + "원이고, 현재 구입 금액은 "
                + 999 + "원 입니다.");
    }

    @ParameterizedTest
    @CsvSource({"1999,999", "1001,1", "1000,0"})
    void 로또_구입시_거스름돈_반환(int money, int expectedChange) {
        // given, when, then
        assertThat(new LottoMoney(money).getChange()).isEqualTo(expectedChange);
    }

    @ParameterizedTest
    @CsvSource({"1999,1", "14001,14", "1000,1"})
    void 로또_구입시_로또_개수_반환(int money, int expectedCount) {
        // given, when, then
        assertThat(new LottoMoney(money).getTotalCount()).isEqualTo(
                expectedCount);
    }

    @ParameterizedTest
    @CsvSource({"1000,1000", "1001,1000", "3999,3000"})
    void 로또_구입시_사용한_금액_반환(int money, int expectedSpentMoney) {
        // given, when, then
        assertThat(new LottoMoney(money).getTotalSpentMoney()).isEqualTo(
                expectedSpentMoney);
    }
}
