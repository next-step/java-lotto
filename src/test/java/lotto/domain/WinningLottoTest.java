package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호를 입력받아 당첨로또 생성시 유효성 검사 (보너스 번호가 로또번호와 중복시 예외발생)")
    void validateWinningLotto() {
        Lotto lotto = new Lotto(LottoNumbers.valueOf("1,2,3,4,5,6"));
        LottoNumber bonusNumber = LottoNumber.from(6);

        assertThatThrownBy(()-> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 로또번호와 중복될 수 없습니다.");
    }
}
