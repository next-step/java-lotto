package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultMatcherTest {

    @Test
    @DisplayName("로또 맞춰보기")
    public void checkLotts() {

        //Given
        List<PickNumbers> lottoNumbers = Arrays.asList(
                new PickNumbers(Arrays.asList(4, 5, 6, 7, 8, 9))
        );
        LottoResultMatcher lottoResultMatcher = new LottoResultMatcher(lottoNumbers);
        WinningNumbers winnerNumbers = new WinningNumbers(Arrays.asList(4, 5, 6, 7, 8, 9), 10);

        //When
        LottoAggregator lottoAggregator = lottoResultMatcher.matching(winnerNumbers);

        //Then
        assertThat(lottoAggregator.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 보너스번호 포함 맞춰보기")
    public void checkBonusLotts() {

        //Given
        List<PickNumbers> lottoNumbers = Arrays.asList(
                new PickNumbers(Arrays.asList(4, 5, 6, 7, 8, 10))
        );
        LottoResultMatcher lottoResultMatcher = new LottoResultMatcher(lottoNumbers);
        WinningNumbers winnerNumbers = new WinningNumbers(Arrays.asList(4, 5, 6, 7, 8, 9), 10);

        //When
        LottoAggregator lottoAggregator = lottoResultMatcher.matching(winnerNumbers);

        //Then
        assertThat(lottoAggregator.get(LottoRank.SECOND)).isEqualTo(1);
    }
}
