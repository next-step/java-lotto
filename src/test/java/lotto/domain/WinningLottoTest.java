package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @DisplayName("객체생성")
    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(Lotto.valueOf("5,10,15,20,25,30"), new LottoNumber(35));
        assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("보너스번호가 당첨번호에 포함되어 있으면 예외 throw")
    @Test
    void validate_보너스번호가_당첨번호에_포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(Lotto.valueOf("5,10,15,20,25,30"), new LottoNumber(10));
        }).withMessageMatching("당첨번호와 보너스번호가 중복되었습니다.");
    }

}
