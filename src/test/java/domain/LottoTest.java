package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 생성")
    @Test
    void lotto() {
        Lotto lotto = new Lotto(new RandomNumberGenerator());

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("당첨번호에 따른 상금을 계산")
    @Test
    void hasPrize() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

        long prize = lotto.hasWinningNumber(Arrays.asList(1, 3, 5, 7, 9, 11));

        assertThat(prize).isEqualTo(3);

    }
}
