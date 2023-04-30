package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }

    @Test
    void createLottoNumbers() throws Exception {
        //given
        int purchaseAmount = 14000;

        //when
        lotto.createLottoNumbers(purchaseAmount);

        //then
        assertThat(lotto.getLottoCount()).isEqualTo(14);
    }

    @Test
    void calculateLottoStatistics() throws Exception {
        //given
        lotto.createLottoNumbers(14000);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when

        //then
        assertDoesNotThrow(() -> lotto.calculateLottoStatistics(winningNumber));
    }
}
