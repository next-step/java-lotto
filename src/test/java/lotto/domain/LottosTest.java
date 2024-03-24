package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또 번호 6자리 생성")
    @Test
    void lottoGenerate() {
        Lotto result = new Lotto();

        assertThat(result.size()).isEqualTo(6);
    }

}
