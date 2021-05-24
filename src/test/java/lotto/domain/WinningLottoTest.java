package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨로또를 유저가 작성한 로또와 비교하여 당첨여부 확인 테스트")
    void matchWinningLotto() {
        LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto winningFirst = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6), LottoType.MANUAL);
        Lotto winningSecond = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 7), LottoType.MANUAL);
        Lotto winningThird = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 8), LottoType.MANUAL);
        Lotto winningFourth = new Lotto(new LottoNumbers(1, 2, 3, 4, 8, 9), LottoType.MANUAL);
        Lotto winningFifth = new Lotto(new LottoNumbers(1, 2, 3, 7, 8, 9), LottoType.MANUAL);
        Lotto winningNothing = new Lotto(new LottoNumbers(7, 8, 9, 10, 11, 12), LottoType.MANUAL);

        assertThat(winningLotto.matchWinning(winningFirst)).isEqualTo(WinningType.FIRST);
        assertThat(winningLotto.matchWinning(winningSecond)).isEqualTo(WinningType.SECOND);
        assertThat(winningLotto.matchWinning(winningThird)).isEqualTo(WinningType.THIRD);
        assertThat(winningLotto.matchWinning(winningFourth)).isEqualTo(WinningType.FOURTH);
        assertThat(winningLotto.matchWinning(winningFifth)).isEqualTo(WinningType.FIFTH);
        assertThat(winningLotto.matchWinning(winningNothing)).isEqualTo(WinningType.NOTHING);
    }

    @Test
    @DisplayName("당첨 번호를 입력받아 당첨로또 생성시 유효성 검사 (보너스 번호가 로또번호와 중복시 예외발생)")
    void validateWinningLotto() {
        LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.from(6);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 로또번호와 중복될 수 없습니다.");
    }
}
