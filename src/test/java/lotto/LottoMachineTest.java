package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    @DisplayName("일치하는 수에 따른 로또 티켓 개수를 구한다")
    void shouldReturnResult() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoMachine lottoMachine = new LottoMachine(lottos());

        HashMap<Integer, Long> result = lottoMachine.result(winningNumbers);

        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(1);
        assertThat(result.get(5)).isEqualTo(1);
        assertThat(result.get(6)).isEqualTo(1);
    }

    private Lottos lottos() {
        return new Lottos(Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)))
        ));
    }
}