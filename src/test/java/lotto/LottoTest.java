package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Model model = new Model();
    private Lotto lotto = new Lotto(model);

    @DisplayName("로또 시작")
    @Test
    void start() {
        assertThat(lotto.isRunning()).isTrue();
    }

}
