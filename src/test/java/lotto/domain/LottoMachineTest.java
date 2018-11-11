package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 스트링티켓을_티켓으로_변환하는_테스트() {
        Ticket result = LottoMachine.convertWinningNumbers("1, 2, 3, 4, 5, 6");

        assertThat(result.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}