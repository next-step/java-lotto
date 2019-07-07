package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("생성 된 로또 수량 확인")
    @Test
    public void 생성_된_로또_수량확인() {
        Lotto lotto = new Lotto();
        List<List<Integer>> autoLottos = lotto.generateStandardLotto(3);
        assertThat(autoLottos.size()).isEqualTo(3);
    }

    @DisplayName("생성 된 로또가 6자리인지 확인")
    @Test
    public void 생성_된_로또_자릿수_확인() {
        Lotto lotto = new Lotto();
        List<List<Integer>> autoLottos = lotto.generateStandardLotto(3);
        for (List<Integer> autoLotto : autoLottos) {
            assertThat(autoLotto.size()).isEqualTo(Lotto.WINNING_NUMBERS_LENGTH);
        }
    }

//    @DisplayName("자동생성 로또 범위 확인: 1 ~ 45")
//    @Test
//    public void 자동생성_로또_범위_확인() {
//        Lotto lotto = new Lotto();
//        List<List<Integer>> autoLottos = lotto.generateStandardLotto(3);
//        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkWinningNumberRange(winningNumbers));
//    }


}
