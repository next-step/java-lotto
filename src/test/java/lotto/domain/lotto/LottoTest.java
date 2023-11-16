package lotto.domain.lotto;

import lotto.domain.lotto.wrapper.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("당첨 번호를 인자로 받아 자신이 가지고 있는 번호와 비교 후 일치하는 개수를 반환한다.")
    @Test
    void countMatchingNumbers() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(1, 5, 12, 21, 32, 43));
        Lotto lotto = new Lotto(lottoNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(Set.of(1, 10, 12, 26, 32, 41));

        // when
        int count = lotto.countMatchingNumbers(winningNumbers);

        // then
        assertThat(count).isEqualTo(3);
    }

}
