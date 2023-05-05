package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 1장 생성 테스트")
    void createLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumber()).hasSize(6);
    }
}
