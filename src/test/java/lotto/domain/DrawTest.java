package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class DrawTest {

    @Test
    @DisplayName("구매금액에 따른 자동 로또 생성 개수 확인")
    void checkNumberOfLottos() {
        Draw draw = new Draw(5000);
        draw.drawLottos(null);
        assertThat(draw.lottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("수동 1개, 자동 4개의 로또를 요청했을 때, 로또 생성 개수 확인")
    void checkNumberOfAutoAndByHand() {
        Draw draw = new Draw(5000, 1);
        String[] stringInputs = {"1", "4", "10", "15", "26", "42"};
        draw.drawLottos(Collections.singletonList(stringInputs));

        assertThat(draw.lottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 당첨 확인이 로또 개수만큼 진행되었는 지 확인")
    void checkWinnings() {
        Draw draw = new Draw(5000);
        Winnings winnings = new Winnings(Arrays.asList(3, 5, 10, 23, 34, 45), 2);
        draw.drawLottos(null);
        draw.checkWinnings(winnings);

        assertThat(Arrays.stream(winnings.recordMatched()).sum()).isEqualTo(5);
    }
}