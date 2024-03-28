package lottery.domain;

import lottery.domain.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 당첨 번호 생성 테스트")
    void winningLottoTest(){
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(winningLotto.winningLotto()).hasSize(WinningLotto.NUMBER_SIZE);
        assertThat(winningLotto.winningLotto()).contains(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        assertThatThrownBy(() -> {
            new WinningLotto(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 비어있으면 안됩니다.");

        assertThatThrownBy(() -> {
            new WinningLotto("1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 로또 번호는 6개만 가능합니다");
    }
}
