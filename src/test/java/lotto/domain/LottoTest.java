package lotto.domain;

import lotto.domain.strategy.LottoGeneration;
import lotto.domain.strategy.ManualLottoGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("로또 번호가 중복이면 에러를 던진다")
    void 로또번호_갯수확인() {
        LottoGeneration lottoGeneration = new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 4, 5));

        assertThatThrownBy(() -> new Lotto(lottoGeneration.generate())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호와 동일한 갯수를 리턴한다")
    void 당첨번호갯수_리턴() {
        Lotto lotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        Lotto winLotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 7, 8, 9)).generate());

        assertThat(lotto.matchCount(winLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 숫자가 있는지 확인한다")
    void 보너스번호_유무_확인() {
        Lotto lotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 7, 8, 9)).generate());
        LottoNumber lottoNumber = LottoNumber.valueOf(7);

        assertThat(lotto.contains(lottoNumber)).isTrue();
    }

    @Test
    @DisplayName("로또와 당첨로또번호를 비교하여 당첨등수 확인")
    void 로또랭킹_확인() {
        Lotto lotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        Lotto winLotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 9)).generate());
        LottoNumber lottoNumber = LottoNumber.valueOf(6);

        assertThat(lotto.findRank(winLotto,lottoNumber)).isEqualTo(LottoRank.SECOND);
    }
}
