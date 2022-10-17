package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("생성자 검증 - 당첨 번호 null")
    void constructorDIExceptionForWinningLottoNull() {
        assertThatThrownBy(() -> new WinningLotto(null, LottoNumber.lottoNumber(7))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자 검증 - 보너스 번호 null")
    void constructorDIExceptionForBonusNumber() {
        Lotto winningLotto = new Lotto(LottoNumber.lottoNumbers().subList(0, 6));
        assertThatThrownBy(() -> new WinningLotto(winningLotto, LottoNumber.lottoNumber(6))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 조회")
    void winningLotto() {
        Lotto lotto = new Lotto(new ArrayList<>(LottoNumber.lottoNumbers().subList(0, 6)));
        assertThat(new WinningLotto(lotto, LottoNumber.lottoNumber(7)).winningLotto().lottoNumbers()).isEqualTo(lotto.lottoNumbers());
    }

    @Test
    @DisplayName("보너스 번호 조회")
    void bonusNumber() {
        Lotto lotto = new Lotto(new ArrayList<>(LottoNumber.lottoNumbers().subList(0, 6)));
        assertThat(new WinningLotto(lotto, LottoNumber.lottoNumber(7)).bonusNumber()).isEqualTo(LottoNumber.lottoNumber(7));
    }
}
