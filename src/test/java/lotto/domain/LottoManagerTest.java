package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    void init() {
        lottoManager = new LottoManager();
    }

    @Test
    void createLottoNumbers() throws Exception {
        //given
        int purchaseAmount = 14000;

        //when
        lottoManager.createLottoNumbers(purchaseAmount);

        //then
        assertThat(lottoManager.getLottoCount()).isEqualTo(14);
    }

    @Test
    void calculateLottoStatistics() throws Exception {
        //given
        lottoManager.createLottoNumbers(14000);
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when

        //then
        assertDoesNotThrow(() -> lottoManager.calculateLottoStatistics(winningTicket));
    }
}
