package lotto.model.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMoneyTest {

    @Test
    void 돈_객체_생성() {
        assertDoesNotThrow(() -> LottoMoney.valueOf(1000));
    }

    @ParameterizedTest
    @CsvSource({"1999,999", "1001,1", "1000,0"})
    void 로또_구입시_거스름돈_반환(int money, long expectedChange) {
        // when
        final LottoMoney change = LottoMoney.valueOf(money).change(Lotto.COST);

        // then
        assertThat(change).isEqualTo(LottoMoney.valueOf(expectedChange));
    }

    @ParameterizedTest
    @CsvSource({"1999,1", "14001,14", "1000,1"})
    void 로또_구입시_로또_개수_반환(int money, int expectedCount) {
        // when
        final long lottosSize = LottoMoney.valueOf(money).sizeOfLottos(Lotto.COST);

        // then
        assertThat(lottosSize).isEqualTo(expectedCount);
    }
}
