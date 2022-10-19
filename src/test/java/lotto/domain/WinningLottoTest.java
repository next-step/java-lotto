package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private List<LottoNumber> lottoNumbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoNumbers = LottoNumber.lottoNumbers().subList(0, 6);
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    @DisplayName("생성자 로또 번호 인자값으로 null이 들어갈 경우 예외가 발생한다.")
    void checkLottoNullException() {
        assertThatThrownBy(() -> new WinningLotto(null, LottoNumber.lottoNumber(7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자 보너스 번호 인자값으로 null이 들어갈 경우 예외가 발생한다.")
    void checkBonusNumberNullException() {
        assertThatThrownBy(() -> new WinningLotto(lotto, LottoNumber.lottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또의 번호를 검증한다.")
    void checkWinningLotto() {
        assertThat(new WinningLotto(lotto, LottoNumber.lottoNumber(7)).lottoNumbers())
                .isEqualTo(lotto.lottoNumbers());
    }

    @Test
    @DisplayName("당첨 로또의 보너스 번호를 검증한다.")
    void checkBonusNumber() {
        assertThat(new WinningLotto(lotto, LottoNumber.lottoNumber(7)).bonusNumber())
                .isEqualTo(LottoNumber.lottoNumber(7));
    }
}
