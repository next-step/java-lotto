package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {

    @Test
    void 돈_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoMoney(1000, 0));
    }

    @Test
    void 돈_객체_값_반환_성공() {
        // given, when, then
        assertThat(new LottoMoney(1000, 0).getValue()).isEqualTo(1000);
    }

    @Test
    void 로또_가격_이하의_돈_객체_생성시_예외_발생() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> new LottoMoney(999, 0));
    }

    @ParameterizedTest
    @CsvSource({"1999,999", "1001,1", "1000,0"})
    void 로또_구입시_거스름돈_반환(int money, int expectedChange) {
        // given, when, then
        assertThat(new LottoMoney(money, 0).getChange()).isEqualTo(expectedChange);
    }

    @ParameterizedTest
    @CsvSource({"1999,1", "14001,14", "1000,1"})
    void 로또_구입시_로또_개수_반환(int money, int expectedCount) {
        // given, when, then
        assertThat(new LottoMoney(money, 0).getTotalCount()).isEqualTo(
                expectedCount);
    }

    @ParameterizedTest
    @CsvSource({"1000,1000", "1001,1000", "3999,3000"})
    void 로또_구입시_사용한_금액_반환(int money, int expectedSpentMoney) {
        // given, when, then
        assertThat(new LottoMoney(money, 0).getTotalSpentMoney()).isEqualTo(
                expectedSpentMoney);
    }

    @Test
    void 로또_전체_수보다_수동_수가_많을_시_예외발생() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> new LottoMoney(2000, 3));
    }

    @Test
    void 로또_수동_장수와_자동_장수_계산_성공() {
        // given
        LottoMoney lottoMoney = new LottoMoney(5000, 3);
        // when
        assertAll(
                () -> assertThat(lottoMoney.getTotalCount())
                        .isEqualTo(lottoMoney.getAutoCount() + lottoMoney.getManualLottoCount()),
                () -> assertThat(lottoMoney.getAutoCount()).isEqualTo(2),
                () -> assertThat(lottoMoney.getManualLottoCount()).isEqualTo(3)

        );
    }
}
