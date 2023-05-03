package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    @Test
    @DisplayName("당첨 확인")
    void winLotto() {
        LottoMachine machine = new LottoMachine(2000);
        Lottos lottos = machine.create(new LottoCreatingRandomStrategy() {
            @Override
            public Lotto create() {
                return new Lotto("1, 2, 3, 4, 5, 6");
            }
        });

        String winningNumbers = "1, 2, 3, 45, 32, 13";
        LottoResult result = new LottoResult(lottos);
        List<Integer> count = result.checkWinningNumbers(winningNumbers);

        assertThat(count).containsExactly(3, 3);
    }
}
