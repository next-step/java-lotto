package lotto.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    private Lotto winningLotto;

    private Lottoes lottoes;

    @BeforeEach
    public void init() {
        winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,7,8)),
                new Lotto(Arrays.asList(1,2,3,9,10,11)),
                new Lotto(Arrays.asList(1,2,3,12,13,14))
        );

        lottoes = new Lottoes(lottoList);

        Prize.clear();
    }

    @Test
    @DisplayName("당첨 결과 카운트 기능 테스트")
    public void increaseWinningCountTest() {

        // when
        Prize.increaseWinningCount(winningLotto, lottoes);

        // then
        assertThat(Prize.FIRST.getPrizeCount()).isEqualTo(0);
        assertThat(Prize.SECOND.getPrizeCount()).isEqualTo(0);
        assertThat(Prize.THIRD.getPrizeCount()).isEqualTo(1);
        assertThat(Prize.FOURTH.getPrizeCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률 계산 기능 테스트")
    public void calculateEarningRateTest() {

        // when
        Prize.increaseWinningCount(winningLotto, lottoes);

        // then
        assertThat(Prize.calculateEarningRate(60000)).isEqualTo(1);
    }
}
