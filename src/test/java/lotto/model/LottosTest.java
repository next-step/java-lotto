package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 맞춰보기")
    public void checkLotts() {

        //Given
        List<PickNumbers> lottoNumbers = Arrays.asList(
                new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new PickNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new PickNumbers(Arrays.asList(10, 11, 12, 13, 14, 15)),
                new PickNumbers(Arrays.asList(4, 5, 6, 7, 8, 9))
        );
        Lottos lottos = new Lottos(lottoNumbers);
        WinningNumbers winnerNumbers = new WinningNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        //When
        LottoResult lottoResult = lottos.matching(winnerNumbers);

        //Then
        assertThat(lottoResult.get(LottoLevels.FIRST)).isEqualTo(1);
        assertThat(lottoResult.get(LottoLevels.THIRD)).isEqualTo(1);
        assertThat(lottoResult.get(LottoLevels.FOURTH)).isEqualTo(2);
        assertThat(lottoResult.get(LottoLevels.BOOM)).isEqualTo(1);
    }
}
