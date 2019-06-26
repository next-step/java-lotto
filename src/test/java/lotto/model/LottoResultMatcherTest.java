package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultMatcherTest {

    @Test
    @DisplayName("로또 맞춰보기")
    public void checkLotts() {

        //Given
        PickNumbers pickNumbers = new PickNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );

        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                ),
                new Number(7)
        );

        Lottos lottos = new Lottos();
        lottos.add(pickNumbers);
        LottoResultMatcher lottoResultMatcher = new LottoResultMatcher(lottos);

        //When
        LottoAggregator lottoAggregator = lottoResultMatcher.matching(winningNumbers);

        //Then
        assertThat(lottoAggregator.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 보너스번호 포함 맞춰보기")
    public void checkBonusLotts() {

        //Given
        PickNumbers pickNumbers = new PickNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );

        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(10)
                ),
                new Number(6)
        );

        Lottos lottos = new Lottos();
        lottos.add(pickNumbers);
        LottoResultMatcher lottoResultMatcher = new LottoResultMatcher(lottos);

        //When
        LottoAggregator lottoAggregator = lottoResultMatcher.matching(winningNumbers);

        //Then
        assertThat(lottoAggregator.get(LottoRank.SECOND)).isEqualTo(1);
    }
}
