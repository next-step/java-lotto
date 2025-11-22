package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    void 로또_번호와_보너스_번호로_생성한다() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningNumbers).isEqualTo(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7));

    }

    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    void 당첨_번호와_일치하는_등수_확인() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(1, 2, 3, 7, 8, 9);
        LottoNumber bonusNumber = new LottoNumber(10);
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        Rank match = winningNumbers.match(lotto);

        assertThat(match).isEqualTo(Rank.FIFTH);
    }
}
