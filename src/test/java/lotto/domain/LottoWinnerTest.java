package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoWinnerTest {

    @Test
    void valid() {
        assertThatThrownBy(
                () -> new LottoWinner(LottoNumberSet.createLottoNumbers(1, 2, 3, 4, 5, 6), new LottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
