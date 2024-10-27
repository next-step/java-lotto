package lotto;

import lotto.lotto.Lottos;
import lotto.lotto.ManualLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoStrategyTest {

    @Test
    @DisplayName("수동 로또 전략으로 로또 생성")
    public void generateLotto() {
        String[] lottoArray = {"1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 15, 16"};
        ManualLottoStrategy manualLottoStrategy = new ManualLottoStrategy(lottoArray);
        Lottos lottos = manualLottoStrategy.generateLotto();
        assertThat(lottos.getLottos()).hasSize(2);
    }

    @Test
    @DisplayName("수동 로또가 없을때 오류 없이 pass")
    public void generateLottoNull() {
        String[] lottoArray = null;
        ManualLottoStrategy manualLottoStrategy = new ManualLottoStrategy(lottoArray);
        Lottos lottos = manualLottoStrategy.generateLotto();
        assertThat(lottos.getLottos()).hasSize(0);
    }

    @Test
    @DisplayName("수동으로 입력한 로또번호는 6개 체크")
    public void generateLottoCheck() {
        String[] lottoArray = {"1, 2, 3, 4, 5, 6, 7"};
        ManualLottoStrategy manualLottoStrategy = new ManualLottoStrategy(lottoArray);
        assertThatThrownBy(() -> {
            Lottos lottos = manualLottoStrategy.generateLotto();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
