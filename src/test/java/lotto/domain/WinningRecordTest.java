package lotto.domain;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRecordTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    public void calculateEarnTest() {

        // given
        Lottoes lottoes = new Lottoes(
                Arrays.asList(
                        Arrays.asList(6, 7, 8, 9, 10, 11),
                        Arrays.asList(1, 2, 6, 7, 8, 9),
                        Arrays.asList(1, 2, 4, 6, 7, 8),
                        Arrays.asList(1, 2, 5, 6, 7, 8)
                )
        );

        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningRecord winningRecord = new WinningRecord(winningLotto);

        // when
        winningRecord.record(lottoes);

        // then
        assertThat(winningRecord.calculateEarnRate(4000)).isEqualTo(26.25);
    }
}
