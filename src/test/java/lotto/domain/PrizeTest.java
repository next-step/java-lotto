package lotto.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    @DisplayName("당첨 결과 계산 기능 테스트")
    public void calculatePrizeTest() {

        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,7)),
                new Lotto(Arrays.asList(1,2,3,4,7,8))
        );

        Lottoes lottoes = new Lottoes(lottoList);

        // when
        Prize.increaseWinningCount(winningLotto, lottoes);

        // then
        assertThat(Prize.FIRST.getPrizeCount()).isEqualTo(1);
        assertThat(Prize.SECOND.getPrizeCount()).isEqualTo(1);
        assertThat(Prize.THIRD.getPrizeCount()).isEqualTo(1);
        assertThat(Prize.FOURTH.getPrizeCount()).isEqualTo(0);
    }
}
