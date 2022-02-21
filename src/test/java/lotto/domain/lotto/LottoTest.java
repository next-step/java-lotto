package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoTestFixtures;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또넘버의_개수는_6개를_넘으면_안된다() {
        assertThatThrownBy(() -> new Lotto(LottoTestFixtures.OVERSIZE_LOTTO_NUMBER))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 넘버는 6개여야 합니다.");
    }

    @Test
    void 로또넘버에는_중복이_없어야_한다() {
        assertThatThrownBy(() -> new Lotto(LottoTestFixtures.DUPLICATED_LOTTO_NUMBER))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 넘버에 중복이 있습니다.");
    }
}
