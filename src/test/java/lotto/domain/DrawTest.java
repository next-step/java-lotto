package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    @DisplayName("구매금액에 따른 로또 생성 개수 확인")
    void checkNumberOfLottos() {
        Draw draw = new Draw(5000);
        draw.drawLottos();

        assertThat(draw.lottos().size()).isEqualTo(5);
    }
}