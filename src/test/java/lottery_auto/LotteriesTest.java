package lottery_auto;

import lottery_auto.domain.Lotteries;
import lottery_auto.domain.Lottery;
import lottery_auto.domain.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    private Lotteries lotteries;
    private List<Integer> winningNumber;

    @BeforeEach
    void setUp() {
        lotteries = new Lotteries(
                Arrays.asList(
                        new Lottery(Arrays.asList(1,2,3,4,5,6)),
                        new Lottery(Arrays.asList(7,8,9,10,11,12))
                ));

        winningNumber = Arrays.asList(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("로또 카운트 테스트")
    void count() {
        assertThat(lotteries.count(winningNumber))
                .isInstanceOf(WinningResult.class);
    }

}
