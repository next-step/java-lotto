package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Lotto;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto = new Lotto();

    @DisplayName("로또번호 범위 확인: 1 ~ 45")
    @Test
    public void 로또번호_범위_확인() {
        Set<List<Integer>> autoLottos = lotto.purchasedLottos(3);
        assertThat(autoLottos.size()).isEqualTo(3);
    }

    @DisplayName("생성 된 로또 수량 확인")
    @Test
    public void 생성_된_로또_수량확인() {
        List<Integer> standardLottoNumbers = Lotto.generateStandardLotto();
        Set<List<Integer>> autoLottos = lotto.purchasedLottos(3);
        assertThat(autoLottos.size()).isEqualTo(3);
    }

    @DisplayName("생성 된 로또가 6자리인지 확인")
    @Test
    public void 생성_된_로또_자릿수_확인() {
        List<Integer> standardLottoNumbers = Lotto.generateStandardLotto();
        Set<List<Integer>> autoLottos = lotto.purchasedLottos(3);
        for (List<Integer> autoLotto : autoLottos) {
            assertThat(autoLotto.size()).isEqualTo(LottoGenerator.WINNING_NUMBERS_LENGTH);
        }
    }
}
