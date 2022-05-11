package lotto;

import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameFactoryTest {
    @Test
    @DisplayName("생성된 로또 번호 개수는 6개이다")
    void generateLotto() {
        assertThat(LottoFactory.createAutoLotto().isSize(6)).isTrue();
    }

}
