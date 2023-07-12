package lotto.model.domain;


import lotto.model.domain.LottoMoney;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> new LottoMoney(999));
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
        assertThat(new LottoMoney(money).getCount()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({"1000,1000", "1001,1000", "3999,3000"})
    void 로또_구입시_사용한_금액_반환(int money, int expectedSpentMoney) {
        // given, when, then
        assertThat(new LottoMoney(money).getSpentMoney()).isEqualTo(expectedSpentMoney);
    }
}
