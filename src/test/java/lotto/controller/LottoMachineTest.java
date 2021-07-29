package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("당첨 테스트")
    void lotteryJackpotTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> correctNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoMachine.lotteryJackpot(lotto, correctNumbers, bonusNumber);

        Map<String, Integer> result = lottoMachine.lotteryRewards();
        System.out.println(result.toString());

        assertThat(result.get(Rank.FIRST.getGrade())).isEqualTo(1);
    }

    @Test
    @DisplayName("2등(보너스번호) 당첨 테스트")
    void bonusJackpotTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> correctNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;

        lottoMachine.lotteryJackpot(lotto, correctNumbers, bonusNumber);

        Map<String, Integer> result = lottoMachine.lotteryRewards();

        assertThat(result.get(Rank.SECOND.getGrade())).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    void thirdJackpotTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> correctNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;

        lottoMachine.lotteryJackpot(lotto, correctNumbers, bonusNumber);

        Map<String, Integer> result = lottoMachine.lotteryRewards();

        assertThat(result.get(Rank.THIRD.getGrade())).isEqualTo(1);
    }

}