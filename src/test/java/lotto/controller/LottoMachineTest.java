package lotto.controller;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("당첨 테스트")
    void lotteryJackpotTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> correctNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        lottoMachine.lotteryJackpot(lotto, correctNumbers);

        Map<String, Object> result = lottoMachine.lotteryRewards();

        assertThat(result.get("first")).isEqualTo(1);
    }

}