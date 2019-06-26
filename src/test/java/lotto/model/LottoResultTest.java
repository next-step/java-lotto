package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 결과(등수별 개수, 총 당첨금)은 로또 1등 1개의 당첨금을 구한다")
    @Test
    void resultFirstPrize() {
        List<Prize> lottoResult = Arrays.asList(Prize.FIRST);

        LottoResult result = LottoResult.of(lottoResult);
        long count = result.countOfPrize(Prize.FIRST);
        Money winningMoney = result.calculateTotalWinningMoney();

        assertThat(count).isEqualTo(1);
        assertThat(winningMoney).isEqualTo(Prize.FIRST.getMoney());
    }

    @DisplayName("당첨 결과 로또 1등 2개 총 당첨금을 구한다")
    @Test
    void resultFirstAndSecondPrize() {
        List<Prize> lottoResult = Arrays.asList(Prize.FIRST, Prize.FIRST);
        Money expectedTotalMoney = Prize.FIRST.getMoney().times(2);

        LottoResult result = LottoResult.of(lottoResult);
        long count = result.countOfPrize(Prize.FIRST);
        Money winningMoney = result.calculateTotalWinningMoney();

        assertThat(count).isEqualTo(2);
        assertThat(winningMoney).isEqualTo(expectedTotalMoney);
    }

    @DisplayName(value = "당첨된 로또가 없을 경우 0원")
    @Test
    void resultNonePrize() {
        List<Prize> lottoResult = Arrays.asList(Prize.NONE);

        LottoResult result = LottoResult.of(lottoResult);

        assertThat(result.countOfPrize(Prize.NONE)).isEqualTo(1);
        assertThat(result.calculateTotalWinningMoney()).isEqualTo(Money.ZERO);
    }
}
