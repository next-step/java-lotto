package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static lotto.domain.LottoSheet.calculateSheetCount;
import static org.assertj.core.api.Assertions.assertThat;

class LottoSheetTest {
    @ParameterizedTest
    @CsvSource(value = {"2_500,2", "3_000,3", "3_500,3"})
    void calculateCount_입력받은_금액만큼에_해당하는_로또_장수를_반환한다(int money, int lottoSheetCount) {
        assertThat(calculateSheetCount(money)).isEqualTo(lottoSheetCount);
    }

    @Test
    void create_입력받은_장수만큼_로또를_여러장_생성한다() {
        int lottoSheetCount = 4;
        List<LottoSheet> lottoSheets = LottoSheet.create(lottoSheetCount);

        assertThat(lottoSheets).hasSize(lottoSheetCount);
        lottoSheets.forEach(lottoSheet -> assertThat(lottoSheet).isInstanceOf(LottoSheet.class));
    }
}
