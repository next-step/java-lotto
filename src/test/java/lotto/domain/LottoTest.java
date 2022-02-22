package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName(value = "로또가 생성될 때, 로또 하나에는 6개의 숫자가 들어간다.")
    @Test
    void checkValidSize() {
        Lotto lotto = new Lotto(new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName(value = "로또 번호가 6개가 아니면 IllegalArgumentException이 발생한다.")
    @Test
    void checkValidRange() {
        assertThatThrownBy(() -> new Lotto(new HashSet(Arrays.asList(1, 2, 3, 4, 5)))).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName(value = "자신이 산 로또번호와 당첨번호를 비교한다")
    @Test
    void matchWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(new HashSet<>(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), new LottoNumber(8));
        Lotto lotto = new Lotto(
            new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        assertThat(lotto.matchWinningLotto(winningLotto)).isEqualTo(6);
    }
}
