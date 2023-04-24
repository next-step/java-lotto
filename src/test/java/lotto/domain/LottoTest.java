package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(new RandomNumberCreation());
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
    void createWinningNumber() throws Exception {
        //given
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when

        //then
        assertDoesNotThrow(() -> lotto.createWinningNumber(winningNumber));
    }

    @Test
    void calculateLottoStatics() throws Exception {
        //given
        lotto.createLottoNumbers(14000);
        lotto.createWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when

        //then
        assertDoesNotThrow(() -> lotto.calculateLottoStatics());
    }
}
