package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName(value = "당첨 번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void distinctWinningAndBonus() {
        assertThatThrownBy(
            () -> new WinningLotto(new Lotto(new HashSet(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))),
                new LottoNumber(6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "로또 티켓의 번호가 당첨번호인지 판별한다")
    @Test
    void hasContainNumber() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(new HashSet<>(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))),
            new LottoNumber(7));
        assertThat(winningLotto.hasContainNumber(new LottoNumber(3))).isTrue();
    }

}
