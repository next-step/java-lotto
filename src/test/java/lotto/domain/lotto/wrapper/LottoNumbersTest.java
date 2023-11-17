package lotto.domain.lotto.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @DisplayName("6개의 Number객체를 컬렉션으로 가지는 Numbers객체를 생성한다.")
    @Test
    void creatNumbers() {
        // given
        Set<Integer> inputs = Set.of(1, 5, 12, 21, 32, 43);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(inputs);

        // then
        assertThat(lottoNumbers.numbers()).hasSize(6)
            .containsExactly(1, 5, 12, 21, 32, 43);
    }

    @DisplayName("자신이 가지고 있는 로또 번호와 인자로 받은 당첨번호(+보너스)의 값이 몇 개 일치하는 지 확인하고 반환한다.")
    @Test
    void countMatchingNumbersWithBonus() {
        // given
        LottoNumbers lotto = new LottoNumbers(Set.of(1, 5, 12, 21, 32, 43));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);

        // when
        int count = lotto.countMatchingNumbers(winningNumber);

        // then
        assertThat(count).isEqualTo(6);
    }
}
