package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.LottoSheet.calculateSheetCount;
import static org.assertj.core.api.Assertions.assertThat;

class LottoSheetTest {
    @ParameterizedTest
    @CsvSource(value = {"2_500,2", "3_000,3", "3_500,3"})
    void calculateCount_입력받은_금액만큼에_해당하는_로또_장수를_반환한다(int money, int lottoSheetCount) {
        assertThat(calculateSheetCount(money)).isEqualTo(lottoSheetCount);
    }
}
