package lottogame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {
    private final static int TIME_OF_GAME = 3;

    private LottoGame lottoGame;
    private int price = 2000;
    private List<LottoNumber> lottoManual;

    @Test
    void CountOFlottoManual_check() {
        lottoManual = new ArrayList<>();
        LottoNumber dummy;

        for (int i = 0; i < TIME_OF_GAME; ++i) {
            dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottoManual.add(dummy);
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lottoGame = new LottoGame(price, lottoManual);
                });
    }
}