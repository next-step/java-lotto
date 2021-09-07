package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.statistics.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또 넘버 5개 일치 및 보너스 넘버 일치시 2등")
    void match2SecondTest() {
        final int bonusNumberValue = 6;
        final Lotto targetLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, bonusNumberValue));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        final LottoNumber bonusNumber = new LottoNumber(bonusNumberValue);

        final Rank actual = targetLotto.matchedRank(winningLottoNumbers, bonusNumber);
        assertThat(actual).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 넘버 5개 일치 및 보너스 넘버 불일치시 3등")
    void match2ThirdTest() {
        final Lotto targetLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        final LottoNumber bonusNumber = new LottoNumber(45);

        final Rank actual = targetLotto.matchedRank(winningLottoNumbers, bonusNumber);
        assertThat(actual).isEqualTo(Rank.THIRD);
    }
}