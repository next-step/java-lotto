package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("입력한 수 만큼 로또 생성")
    @Test
    void generate() {
        Lottos lottos = Lottos.autoGenerate(3);
        assertThat(lottos.size()).isEqualTo(3);
    }
}
