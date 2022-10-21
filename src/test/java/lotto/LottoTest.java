package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void generate() {
        Lotto lotto = Lotto.generate();
        Assertions.assertThat(lotto).isEqualTo(Lotto.from(lotto));
    }
}