package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    void when_hasNoLotteries_Expects_sizeZero() {
        // given
        int lotteryCount = 0;

        Lotteries lotteries = new Lotteries(lotteryCount);

        assertThat(lotteries.size()).isEqualTo(0);
    }

    @Test
    void generate_Lotteries() {
        // given
        int lotteryCount = 10;

        // when
        Lotteries lotteries = new Lotteries(lotteryCount);

        // assert
        assertThat(lotteries.size()).isEqualTo(10);

    }

    /**
     * 아래 두개 테스트 어떻게 하지
     */
    @Test
    @DisplayName("당첨 번호와 일치하는 로또를 계산한다")
    void when_input_is_given() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotteries lotteries = new Lotteries(100, winningNumbers);
        List<Integer> integers = lotteries.calculateResult(winningNumbers);
        System.out.println(integers);
    }

    @Test
    @DisplayName("5개일치하는 로또들 중 보너스볼 일치여부를 포함한 결과를 계산해 반환한다.")
    void calculate_matchesWithBonusNum() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotteries lotteries = new Lotteries(100, winningNumbers);
        int bonusNum = 10;
        List<Integer> results = lotteries.calculateBonusNum(winningNumbers,10);

    }
}