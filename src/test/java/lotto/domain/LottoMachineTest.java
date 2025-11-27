package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void create() {
        int[] nums = LottoMachine.createLottoNumbers();

        assertThat(nums).hasSize(6);
    }
}
