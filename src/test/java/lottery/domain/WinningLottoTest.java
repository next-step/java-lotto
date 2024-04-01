package lottery.domain;

import lottery.domain.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 당첨 번호 생성 테스트")
    void winningLottoTest(){
        final WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);

        assertThat(winningLotto.winningNumbers()).hasSize(WinningLotto.NUMBER_SIZE);
        assertThat(winningLotto.winningNumbers()).contains(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        assertThat(winningLotto.bonusNumbers().equals(new LottoNumber(7)));

        assertThatThrownBy(() -> {
            new WinningLotto(" ", 7);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 비어있으면 안됩니다.");

        assertThatThrownBy(() -> {
            new WinningLotto("1, 2, 3, 4, 5", 7);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 로또 번호는 6개만 가능합니다");

        assertThatThrownBy(() -> {
            new WinningLotto("1, 2, 3, 4, 5, 6", 6);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 볼은 당첨번호와 중복되면 안됩니다.");
    }
}
