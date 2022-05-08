package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class DrawTest {

    Draw draw;

    @BeforeEach
    void setUp() {
        draw = new Draw(5000);
    }

    @Test
    @DisplayName("구매금액에 따른 로또 생성 개수 확인")
    void checkNumberOfLottos() {
        draw.drawLottos();
        assertThat(draw.lottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 당첨 확인이 로또 개수만큼 진행되었는 지 확인")
    void checkWinnings() {
        Winnings winnings = new Winnings(Arrays.asList(3, 5, 10, 23, 34, 45));
        draw.drawLottos();
        draw.checkWinnings(winnings);

        assertThat(Arrays.stream(winnings.recordMatched()).sum()).isEqualTo(5);
    }
}