package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @DisplayName("로또번호 생성 확인")
    @Test
    void lott_shuffle() {
        Lottos lottos = Lotto.create(1);
        assertThat(lottos.getLottoList().size()).isEqualTo(1);
    }
}
