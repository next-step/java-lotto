package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 결과(등수별 개수, 총 당첨금)은 로또 1등 당첨 개수를 구한다")
    @Test
    void resultFirstPrize() {
        LottoResult result = LottoResult.of(Prize.FIRST);

        long count = result.countOfPrize(Prize.FIRST);

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("당첨 결과 로또 1등 2개 총 당첨금을 구한다")
    @Test
    void resultFirstAndSecondPrize() {
        LottoResult result = LottoResult.of(Prize.FIRST, Prize.FIRST);
        long count = result.countOfPrize(Prize.FIRST);

        assertThat(count).isEqualTo(2);
    }

    @DisplayName(value = "당첨된 로또가 없을 경우 0원")
    @Test
    void resultNonePrize() {
        LottoResult result = LottoResult.of(Prize.NONE);

        assertThat(result.countOfPrize(Prize.NONE)).isEqualTo(1);
        assertThat(result.getRateOfReturn()).isEqualTo(0);
    }
}