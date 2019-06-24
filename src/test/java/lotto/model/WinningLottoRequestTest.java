package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoRequestTest {

    @DisplayName("사용자가 입력한 값을 number로 생성")
    @Test
    void createWinningLottoRequest() {
        String numbers = "1,2,3,4,5,6";
        int bonus = 7;

        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of(numbers, bonus);

        assertThat(winningLottoRequest.getNumbers()).contains(Number.of(1), Number.of(2), Number.of(3), Number.of(4));
        assertThat(winningLottoRequest.getBonus()).isEqualTo(Number.of(7));
    }
}
