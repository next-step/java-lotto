package lotto.domain;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCountTest {

    private final WinningCount winningCount;

    public WinningCountTest() {

        // given
        Lottoes lottoes = new Lottoes(
                Arrays.asList(
                        Arrays.asList(6, 7, 8, 9, 10, 11),
                        Arrays.asList(1, 2, 6, 7, 8, 9),
                        Arrays.asList(1, 2, 4, 7, 8, 9),
                        Arrays.asList(1, 2, 5, 6, 7, 8)
                )
        );

        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoNumber bonusBall = new LottoNumber(7);

        winningCount = lottoes.countWinLotto(winningLotto, bonusBall);
    }

    @Test
    @DisplayName("당첨 결과 증가 테스트")
    public void increaseCountTest() {

        // when
        long matchCountOfFifth = winningCount.getMatchCount(Rank.FIFTH);
        long matchCountOfFourth = winningCount.getMatchCount(Rank.FOURTH);

        // then
        assertThat(matchCountOfFifth).isEqualTo(2);
        assertThat(matchCountOfFourth).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨 상금 계산 테스트")
    public void calculatePrizeTest() {

        // when
        long prize = winningCount.calculatePrize();

        // then
        assertThat(prize).isEqualTo(60_000);
    }
}
