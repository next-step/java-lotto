package lotto.domain.lotto;

import lotto.domain.lotto.wrapper.LottoNumber;
import lotto.domain.lotto.wrapper.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("당청 보너스 번호를 인자로 받아 자신의 보너스 번호와 비교한다.")
    @Test
    void isEqualWith() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(1, 5, 12, 21, 32, 43));
        LottoNumber bonusNumber = new LottoNumber(10);
        Lotto lotto = new Lotto(lottoNumbers, bonusNumber);

        LottoNumber winningBonusNum = new LottoNumber(9);

        // when
        boolean result = lotto.isBonusNumEqualWith(winningBonusNum);

        // then
        assertThat(result).isFalse();
    }

}
