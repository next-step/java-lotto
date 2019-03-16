package lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 당첨로또번호생성() {
        List<Integer> winningNumbers = LottoMachine.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        assertThat(winningNumbers).hasSize(6);
    }

}