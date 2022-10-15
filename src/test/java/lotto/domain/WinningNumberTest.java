package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("생성자 검증 - 당첨 번호 null")
    void constructorDIExceptionForWinningNumberNull() {
        assertThatThrownBy(() -> new WinningNumber(null, LottoNumber.lottoNumber(7))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자 검증 - 보너스 번호 null")
    void constructorDIExceptionForBonusNumber() {
        Lotto winningNumber = new Lotto(LottoNumber.lottoNumbers().subList(0, 6));
        assertThatThrownBy(() -> new WinningNumber(winningNumber, LottoNumber.lottoNumber(6))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 조회")
    void winningNumber() {
        Lotto lotto = new Lotto(new ArrayList<>(LottoNumber.lottoNumbers().subList(0, 6)));
        assertThat(new WinningNumber(lotto, LottoNumber.lottoNumber(7)).winningNumber().lottoNumbers()).isEqualTo(lotto.lottoNumbers());
    }

    @Test
    @DisplayName("보너스 번호 조회")
    void bonusNumber() {
        Lotto lotto = new Lotto(new ArrayList<>(LottoNumber.lottoNumbers().subList(0, 6)));
        assertThat(new WinningNumber(lotto, LottoNumber.lottoNumber(7)).bonusNumber()).isEqualTo(LottoNumber.lottoNumber(7));
    }
}
