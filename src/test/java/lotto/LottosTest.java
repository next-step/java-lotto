package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumbers;
import lotto.lotto.Lottos;
import lotto.result.MatchedNumbersCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lottos 객체를 생성한다")
    void shouldCreateSameObject() {
        Lottos lottos = lottos();
        assertThat(lottos).isEqualTo(lottos());
    }

    @Test
    @DisplayName("로또 번호가 주어진 개수만큼 일치하는 로또의 개수를 구한다")
    void shouldReturnCount() {
        Lottos lottos = lottos();
        LottoNumbers winningNumbers = winningNumbers();

        long count = lottos.match(winningNumbers, MatchedNumbersCount.THREE);
        assertThat(count).isEqualTo(1L);
    }

    private Lottos lottos() {
        return new Lottos(Arrays.asList(
                Lotto.from(Arrays.asList(1, 2, 3, 7, 8, 9)),
                Lotto.from(Arrays.asList(1, 2, 3, 4, 7, 8)))
        );
    }

    private LottoNumbers winningNumbers() {
        return LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}